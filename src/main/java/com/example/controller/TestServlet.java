package com.example.controller;

import com.easypost.model.Webhook;
import com.example.dao.TestDataStore;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Enumeration;


/**
 * @author garden
 * @create 4/7/18
 */

@WebServlet(name = "helloworld", value = "/")
public class TestServlet extends HttpServlet {
    private BufferedReader bufferedReader;
    private StringBuilder stringBuilder;
    TestDataStore testDataStore = new TestDataStore();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            InputStream inputStream = req.getInputStream();
            Enumeration enumeration = req.getHeaderNames();
            stringBuilder = new StringBuilder();
            while (enumeration.hasMoreElements()) {
                String key = (String) enumeration.nextElement();
                stringBuilder.append(key + ":" + req.getHeader(key) + "\n");
            }
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            } else {
                stringBuilder.append("Nothing in the request Body or this is a GET request");
            }
            PrintWriter out = resp.getWriter();
            testDataStore.testAdd(stringBuilder.toString());
            out.write(stringBuilder.toString());
        } catch (Exception e) {
            testDataStore.testAdd(e.getMessage());
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }
}
