package com.example.controller;

import com.example.dao.TrackingDao;
import com.example.helper.RequestParameters;
import com.example.helper.ResponseHelper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author garden
 * @create 4/29/18
 */
@WebServlet(name = "deleteTracking", value = "/delete")
public class TrackingDeleteServlet extends HttpServlet {
    private TrackingDao trackingDao = new TrackingDao();
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String userId = req.getParameter(RequestParameters.USERID.toString());
        String trackingCode = req.getParameter(RequestParameters.TRACKINGCODE.toString());
        String carrier = req.getParameter(RequestParameters.CARRIER.toString());
        String trackerId = trackingDao.getTrackerIdByTrackingCodeAndCarrier(trackingCode, carrier);
        if(trackerId != null){
            trackingDao.deleteTrackerById(userId, trackerId);
        }else{
            System.out.println("Try to delete a null tracker");
        }

        //TODO to confirm the format of response
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        doGet(req, resp);
    }
}
