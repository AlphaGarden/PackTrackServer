package com.example.controller;

import com.easypost.model.Tracker;
import com.example.dao.EasyPostDao;
import com.example.dao.TrackingDao;
import com.example.error.FirebaseException;
import com.example.error.JacksonUtilityException;
import com.example.helper.RequestParameters;
import com.example.helper.ResponseHelper;
import com.example.model.ServerInfo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author garden
 * @create 4/24/18
 */

@WebServlet(name = "createTracking", value = "/create")
public class TrackerCreateServlet extends HttpServlet {
    private static EasyPostDao easyPostDao = EasyPostDao.getEasyPostDao();
    private static TrackingDao trackingDao = new TrackingDao();
    private static ResponseHelper responseHelper = ResponseHelper.getResponseHelper();
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
      try{
          String userId = req.getParameter(RequestParameters.USERID.toString());
          String carrier = req.getParameter(RequestParameters.CARRIER.toString());
          String trackingCode = req.getParameter(RequestParameters.TRACKINGCODE.toString());
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
          responseHelper.sendResponse(resp, tracker, HttpServletResponse.SC_OK);

      }catch (JacksonUtilityException  e){
          ServerInfo info = new ServerInfo("Server Internal error with JacksonUtilityException.");
          responseHelper.sendResponse(resp, info, HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
      }catch (FirebaseException e1){
          ServerInfo info = new ServerInfo("Server Internal error with FireBaseException.");
          responseHelper.sendResponse(resp, info, HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
      }catch (Exception e){
          ServerInfo info = new ServerInfo("Server Internal error.");
          responseHelper.sendResponse(resp, info, HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
      }
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }
}
