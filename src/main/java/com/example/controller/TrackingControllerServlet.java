package com.example.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author garden
 * @create 4/24/18
 */
@WebServlet(name = "tracking", value = "/tracking")
public class TrackingControllerServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // If we want to get a detail info with its userId and tracking number
        // If we want to get its history info with its userId

    }
}
