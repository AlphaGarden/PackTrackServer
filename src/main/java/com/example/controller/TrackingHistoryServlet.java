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
        String userId = req.getParameter(RequestParameters.USERID.toString());
        List<Tracker> historys = trackingDao.getAllTrackers(userId);
        if (historys != null){
            responseHelper.sendResponse(resp, historys);
        }else{
            System.out.println("The history is null");
            // TODO to make a rule that when response is null
        }

    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        doGet(req, resp);
    }
}
