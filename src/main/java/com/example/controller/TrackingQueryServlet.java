package com.example.controller;

import com.easypost.model.Tracker;
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
@WebServlet(name = "TrackingQuery", value = "/query")
public class TrackingQueryServlet extends HttpServlet {
    private ResponseHelper responseHelper = ResponseHelper.getResponseHelper();
    private TrackingDao trackingDao = new TrackingDao();
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String trackingCode = req.getParameter(RequestParameters.TRACKINGCODE.toString());
        String carrier = req.getParameter(RequestParameters.CARRIER.toString());
        String trackerId = trackingDao.getTrackerIdByTrackingCodeAndCarrier(trackingCode, carrier);
        Tracker tracker = trackingDao.getOneTracker(trackerId);
        if (tracker != null){
            responseHelper.sendResponse(resp, tracker);
        }else{
            System.out.println("Tracker is null");
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doPost(req, resp);
    }
}