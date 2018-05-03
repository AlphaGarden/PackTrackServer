package com.example.controller;



import com.easypost.model.*;
import com.example.configure.SysConfigHelper;
import com.example.dao.CloudMessageDao;
import com.example.dao.TrackingDao;
import com.example.error.FirebaseException;
import com.example.error.JacksonUtilityException;
import com.example.helper.JsonConverter;
import com.example.helper.MailHelper;
import com.example.helper.ResponseHelper;
import com.example.model.CloudMessage;
import com.example.model.EasyMail;
import com.example.model.ServerInfo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/**
 * @author garden
 * @create 4/23/18
 */
@WebServlet(name = "update", value = "/update")
public class TrackerUpdateServlet extends HttpServlet {
    private static TrackingDao trackingDao = new TrackingDao();
    private static SysConfigHelper sysConfigHelper = SysConfigHelper.getCredentialHelper();
    private static CloudMessageDao cloudMessageDao = new CloudMessageDao();
    private static ExecutorService executor ;
    private static MailHelper mailHelper = MailHelper.getInstance();
    private static ResponseHelper responseHelper = ResponseHelper.getResponseHelper();
    private static JsonConverter converter= JsonConverter.getConverter();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        doPost(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        try{
            Event event = converter.convertFromJsonInputStrem(req.getInputStream(), Event.class);
            Tracker tracker = (Tracker)event.getResult();
            List<TrackingDetail> trackingDetails = tracker.getTrackingDetails();
            TrackingDetail newDetail = trackingDetails.get(trackingDetails.size() - 1);
            TrackingLocation location = newDetail.getTrackingLocation();
            if (tracker != null && location !=null){
                String trackerId = tracker.getId();
                trackingDao.updateTrackerByTrackerId(trackerId, tracker);
                List<String> userEmails = trackingDao.getEmailsByTrackerId(trackerId);
                String trackingCode = tracker.getTrackingCode();
                String carrier = tracker.getCarrier();
                String updateAt = newDetail.getDatetime().toString();
                String locationInfo = location.getCity() + "," + location.getState() + " "+ location.getCountry();
                String status = newDetail.getMessage();
                // TODO Implement with multi-thread

                CloudMessage message = CloudMessage.builder()
                        .withToClient(trackerId)
                        .build();
                cloudMessageDao.send(message);
//                for(String userId : userIds){
//                    CloudMessage message = CloudMessage.builder()
//                            .withToClient(userId)
//                            .withTracker(tracker)
//                            .build();
//                    cloudMessageDao.send(message);
//                }

                //  Implementation of sending email with multi-thread and thread pool
                executor = Executors.newFixedThreadPool(sysConfigHelper.getThreadPoolSize());
                for(String email : userEmails){
                    //  Send email to every user
                    EasyMail easyMail = new EasyMail(null,
                            "PacTack-Update for: "+trackingCode,
                            trackingCode,
                            carrier,
                            updateAt,
                            locationInfo,
                            status);
                    easyMail.setReceiptant(email);
                    executor.execute(mailHelper.createSendThread(easyMail));
                }

                // When all mail is ready to be sent
                executor.shutdown();
                executor.awaitTermination(30, TimeUnit.SECONDS );

                ServerInfo info  = new ServerInfo("Update Succeeded");
                responseHelper.sendResponse(resp, info, HttpServletResponse.SC_OK);

            }else{
                System.out.println("The tracker retrieved from the event object is null");
            }
        }catch (JacksonUtilityException e){
            ServerInfo info = new ServerInfo("Server Internal error with JacksonUtilityException.");
            responseHelper.sendResponse(resp, info, HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }catch (FirebaseException e1){
            ServerInfo info = new ServerInfo("Server Internal error with FireBaseException.");
            responseHelper.sendResponse(resp, info, HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            e.printStackTrace();
            ServerInfo error = new ServerInfo("Servlet Internal Error.");
            responseHelper.sendResponse(resp, error, HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
