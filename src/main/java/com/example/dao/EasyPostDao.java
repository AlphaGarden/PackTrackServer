package com.example.dao;


import com.easypost.EasyPost;
import com.example.configure.CredentialHelper;
import com.example.model.EasyTracker;
import com.example.model.EasyTrackingDetail;

import java.util.HashMap;
import java.util.List;

/**
 * @author garden
 * @create 4/26/18
 */
public class EasyPostDao implements EasyPostDaoInterface{
    private static EasyPostDao easyPostDao;
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
    public EasyTracker createEasyTrackerByTrackingCode(String trackingCode, String carrier) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("tracking_code", trackingCode);
        params.put("carrier", carrier);

        return null;
    }

    @Override
    public EasyTracker getEasyTrackerByTrackingCode(String trackingCode) {
        return null;
    }

    @Override
    public List<EasyTrackingDetail> getTrackingDetailsByTrackingCode(String trackingCode) {
        return null;
    }

    // Get Tracker info by the trackingCode


}
