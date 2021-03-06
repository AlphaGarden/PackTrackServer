package com.example.controller;

import com.easypost.model.Tracker;
import com.example.dao.TrackingDao;
import com.example.error.FirebaseException;
import com.example.error.JacksonUtilityException;
import com.example.helper.RequestParameters;
import com.example.helper.ResponseHelper;
import com.example.model.ServerInfo;
import com.example.model.TrackingRecord;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author garden
 * @create 4/29/18
 */
@WebServlet(name = "TrackingHistory", value = "/history")
public class TrackingHistoryServlet extends HttpServlet {
    private TrackingDao trackingDao = new TrackingDao();
    private ResponseHelper responseHelper = ResponseHelper.getResponseHelper();
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
       try{
           String userId = req.getParameter(RequestParameters.USERID.toString());
           List<Tracker> trackers = trackingDao.getAllTrackers(userId);
           if (trackers != null){
               List<TrackingRecord> records = new LinkedList<>();
               for (Tracker tracker : trackers){
                   records.add(new TrackingRecord(
                           tracker.getTrackingCode(),
                           tracker.getCarrier(),
                           tracker.getUpdatedAt().toString()
                   ));
               }
               responseHelper.sendResponse(resp, records, HttpServletResponse.SC_OK);
           }else{
               ServerInfo info = new ServerInfo("Can't find the trackers by user Id"+ userId);
               responseHelper.sendResponse(resp, info, HttpServletResponse.SC_NOT_FOUND);
           }
       }catch (JacksonUtilityException e){
           ServerInfo info = new ServerInfo("Server Internal error with JacksonUtilityException.");
           responseHelper.sendResponse(resp, info, HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
       }catch (FirebaseException e1){
           ServerInfo info = new ServerInfo("Server Internal error with FireBaseException.");
           responseHelper.sendResponse(resp, info, HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
       }catch (Exception e){
           ServerInfo info = new ServerInfo("Servlet Internal Error.");
           responseHelper.sendResponse(resp, info, HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
       }

    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        doGet(req, resp);
    }
}
