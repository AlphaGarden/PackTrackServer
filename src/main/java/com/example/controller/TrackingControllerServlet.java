package com.example.controller;

import com.easypost.model.Tracker;
import com.example.dao.EasyPostDao;
import com.example.dao.TrackingDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author garden
 * @create 4/24/18
 */
@WebServlet(name = "createTracking", value = "/createTracking")
public class TrackingControllerServlet extends HttpServlet {
    private static EasyPostDao easyPostDao = EasyPostDao.getEasyPostDao();
    private static TrackingDao trackingDao = new TrackingDao();
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String userId = req.getParameter("userId");
        String carrier = req.getParameter("carrier");
        String trackingCode = req.getParameter("trackingCode");
        String trackerId = trackingDao.getTrackerIdByTrackingCodeAndCarrier(trackingCode, carrier);
        Tracker tracker;
        // When the tracker is not created
        if (trackerId == null){
            // Then we create it
            tracker = easyPostDao.createTrackerByTrackingCodeAndCarrier(trackingCode, carrier);
            trackerId = tracker.getId();
            // save the user id and the corresponding tracker Id into the database
            trackingDao.insert(userId, trackerId);
            // save tracking code, carrier and corresponding tracker id into the database
            trackingDao.insert(trackingCode, carrier, trackerId);
            // save the tracker id and the corresponding tracker into the database
            trackingDao.insert(trackerId, tracker);
        }else{
            tracker = trackingDao.getOneTracker(trackerId);
        }

        // return its tracking details.


    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }
}
