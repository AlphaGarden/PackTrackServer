package com.example.controller;



import com.easypost.model.*;
import com.example.configure.SysConfigHelper;
import com.example.dao.CloudMessageDao;
import com.example.dao.TrackingDao;
import com.example.helper.MailHelper;
import com.example.model.CloudMessage;
import com.example.model.EasyMail;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
    private static final Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .registerTypeAdapter(Event.class, new EventDeserializer())
            .registerTypeAdapter(Rate.class, new RateDeserializer())
            .create();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        doPost(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        InputStream inputStream = req.getInputStream();
        Event event = gson.fromJson(
                new InputStreamReader(inputStream, "utf-8"), Event.class);
        Tracker tracker = (Tracker)event.getResult();
        if (tracker != null){
            String trackerId = tracker.getId();
            trackingDao.updateTrackerByTrackerId(trackerId, tracker);
            List<String> userIds = trackingDao.getAllUserIdsByTrackerId(trackerId);
            List<String> userEmails = trackingDao.getEmailsByTrackerId(trackerId);
            // TODO Implement with multi-thread

            for(String userId : userIds){
                CloudMessage message = CloudMessage.builder()
                        .withToClient(userId)
                        .withMessage("Hello world")
                        .build();
                cloudMessageDao.send(message);
            }
            //  Implementation of sending email with multi-thread and thread pool
            executor = Executors.newFixedThreadPool(sysConfigHelper.getThreadPoolSize());
            for(String email : userEmails){
                // TODO Send email to every user
                EasyMail easyMail = new EasyMail(null,"Test from update", "<h1>Hello world</h1>");
                easyMail.setReceiptant(email);
                executor.execute(mailHelper.createSendThread(easyMail));
            }
            // When all mail is ready to be sent
            executor.shutdown();
            try {
                executor.awaitTermination(30, TimeUnit.SECONDS );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }else{
            System.out.println("The tracker retrieved from the event object is null");
        }
    }
}
