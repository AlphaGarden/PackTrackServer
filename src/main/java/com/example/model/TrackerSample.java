package com.example.model;

/**
 * @author garden
 * @create 4/15/18
 */
import com.easypost.EasyPost;
import com.easypost.exception.EasyPostException;
import com.easypost.model.*;
import com.example.configure.SysConfigHelper;

import java.util.HashMap;
import java.util.Map;

public class TrackerSample {

    public TrackerSample(){
        EasyPost.apiKey= SysConfigHelper.getCredentialHelper().getEasypostApiKey();
    }
    public void createTracker(){
        HashMap<String, Object> params = new HashMap<>();
        params.put("tracking_code", "EZ5000000005");
        params.put("carrier","FedEx");
        Tracker tracker = null;
        try {
            tracker = Tracker.create(params);
        } catch (EasyPostException e) {
            e.printStackTrace();
        }
        System.out.println(tracker.getStatus());
        System.out.println(tracker.getCarrierDetail().getService());
        System.out.println(tracker.getEstDeliveryDate().toString());
        System.out.println(tracker.getUpdateAt());
        for(TrackingDetail detail: tracker.getTrackingDetails()){
            System.out.println(detail.getMessage());
            System.out.println(detail.getStatusDetail());
            System.out.println(detail.getDatetime().toString());
            System.out.println(detail.getTrackingLocation().getCity());
            System.out.println(detail.getTrackingLocation().getState());
            System.out.println(detail.getTrackingLocation().getCountry());
            System.out.println(detail.getTrackingLocation().getZip());
            System.out.println("-----------------------");
        }
    }
    public void listWebhookCollectionUrl(){
        WebhookCollection webhookCollection = null;
        try {
            webhookCollection = Webhook.all();
            for(Webhook webhook : webhookCollection.getWebhooks()){
                System.out.println(webhook.getUrl());
            }
        } catch (EasyPostException e) {
            e.printStackTrace();
        }
    }
    public void deleteAllWebhook(){
        WebhookCollection webhookCollection = null;
        try {
            webhookCollection = Webhook.all();
            for(Webhook webhook : webhookCollection.getWebhooks()){
                webhook.delete(webhook.getId());
            }
        } catch (EasyPostException e) {
            e.printStackTrace();
        }
    }
    public void createWebhookWithUrl(String url){
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("url", url);
        try {
            Webhook webhook = Webhook.create(paraMap);
        } catch (EasyPostException e) {
            e.printStackTrace();
        }
    }

}
