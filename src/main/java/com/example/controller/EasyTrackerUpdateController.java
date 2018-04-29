package com.example.controller;



import com.easypost.model.*;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Track;
import java.io.*;


/**
 * @author garden
 * @create 4/23/18
 */
@WebServlet(name = "update", value = "/update")
public class EasyTrackerUpdateController extends HttpServlet {
    private final Gson gson = new GsonBuilder()
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
    }
}
