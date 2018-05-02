package com.example.dao;


import com.easypost.EasyPost;
import com.easypost.exception.EasyPostException;
import com.easypost.model.Tracker;
import com.easypost.model.TrackingDetail;
import com.example.configure.SysConfigHelper;


import java.util.HashMap;
import java.util.List;

/**
 * @author garden
 * @create 4/26/18
 */
public class EasyPostDao implements EasyPostDaoInterface{
    private static EasyPostDao easyPostDao;

    private EasyPostDao(){
        EasyPost.apiKey= SysConfigHelper.getCredentialHelper().getEasypostApiKey();
    }
    public static EasyPostDao getEasyPostDao(){
        if (easyPostDao != null){
            return easyPostDao;
        }else {
            easyPostDao = new EasyPostDao();
            return easyPostDao;
        }
    }

    @Override
    public Tracker createTrackerByTrackingCodeAndCarrier(String trackingCode, String carrier) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("tracking_code", trackingCode);
        params.put("carrier", carrier);
        Tracker tracker = null;
        try {
            tracker = Tracker.create(params);
        } catch (EasyPostException e) {
           System.out.println("Unknown error happened in create Tracker Function.");
        }
        return tracker;
    }

    @Override
    public Tracker getTrackerByTrackerId(String trackerId) {
        Tracker tracker = null;
        try {
            tracker = Tracker.retrieve(trackerId);
        } catch (EasyPostException e) {
            System.out.println("Unknown Tracker Id");
        }
        return tracker;
    }

    @Override
    public List<TrackingDetail> getTrackingDetailsByTrackerId(String trackerId) {
        List<TrackingDetail> trackingDetails = null;
        Tracker tracker = null;
        try {
            tracker = Tracker.retrieve(trackerId);
        } catch (EasyPostException e) {
            System.out.println("Unknown Tracker Id");
        }
        if(tracker != null){
            trackingDetails = tracker.getTrackingDetails();
        }else{
            System.out.println("Null trackingDetails from the tracker.");
        }
        return trackingDetails;
    }
}
