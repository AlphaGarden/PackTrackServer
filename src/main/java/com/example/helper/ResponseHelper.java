package com.example.helper;

import com.easypost.model.TrackingDetail;
import com.google.gson.Gson;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author garden
 * @create 4/29/18
 */
public class ResponseHelper {
    private static ResponseHelper responseHelper;
    private ResponseHelper(){}
    public static ResponseHelper getResponseHelper(){
        if(responseHelper != null){
            return responseHelper;
        }else{
            responseHelper = new ResponseHelper();
            return responseHelper;
        }
    }

    public <T> void sendResponse(HttpServletResponse response, T details) throws IOException {
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        response.setContentType("application/json");
        out.print(gson.toJson(details));
        out.flush();
    }
}
