package com.example.controller;

import com.easypost.model.Tracker;
import com.example.dao.TrackingDao;
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
           }
       }catch (Exception e){
           ServerInfo info = new ServerInfo("Servlet Internal Error.");
       }

    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        doGet(req, resp);
    }
}
