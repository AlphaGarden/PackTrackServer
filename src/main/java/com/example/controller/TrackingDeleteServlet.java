package com.example.controller;

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
 * @create 4/29/18
 */
@WebServlet(name = "deleteTracking", value = "/delete")
public class TrackingDeleteServlet extends HttpServlet {
    private static TrackingDao trackingDao = new TrackingDao();
    private static ResponseHelper responseHelper = ResponseHelper.getResponseHelper();
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try{
            String userId = req.getParameter(RequestParameters.USERID.toString());
            String trackingCode = req.getParameter(RequestParameters.TRACKINGCODE.toString());
            String carrier = req.getParameter(RequestParameters.CARRIER.toString());
            String trackerId = trackingDao.getTrackerIdByTrackingCodeAndCarrier(trackingCode, carrier);
            if(trackerId != null){
                trackingDao.deleteTrackerById(userId, trackerId);
                ServerInfo info = new ServerInfo("Delete Success");
                responseHelper.sendResponse(resp, info, HttpServletResponse.SC_OK);
            }else{
                ServerInfo info = new ServerInfo("Delete Failed with invalid tracking code");
                responseHelper.sendResponse(resp, info, HttpServletResponse.SC_NOT_FOUND);
                System.out.println("Try to delete a null tracker");
            }
        }catch (JacksonUtilityException e){
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
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        doGet(req, resp);
    }
}
