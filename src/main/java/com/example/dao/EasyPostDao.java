package com.example.dao;


import com.easypost.EasyPost;
import com.easypost.exception.EasyPostException;
import com.easypost.model.Tracker;
import com.easypost.model.TrackingDetail;
import com.example.configure.CredentialHelper;


import java.util.HashMap;
import java.util.List;

/**
 * @author garden
 * @create 4/26/18
 */
public class EasyPostDao implements EasyPostDaoInterface{
    private static EasyPostDao easyPostDao;
    private static TrackingDao trackingDao;

    private EasyPostDao(){
        EasyPost.apiKey= CredentialHelper.getCredentialHelper().getEasypostApiKey();
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
    public Tracker createTrackerByTrackingCode(String trackingCode, String carrier) {
        return null;
    }

    @Override
    public Tracker getTrackerByTrackerId(String trackerId) {
        return null;
    }

    @Override
    public List<TrackingDetail> getTrackingDetailsByTrackerId(String trackerId) {
        return null;
    }
}
