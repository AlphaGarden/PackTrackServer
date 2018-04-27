package com.example.dao;

import com.example.model.EasyTracker;
import com.example.model.EasyTrackingDetail;

import java.util.List;

/**
 * @author garden
 * @create 4/26/18
 */
public interface EasyPostDaoInterface {

    /**
     *
     * @param trackingCode The code of a shipment
     * @param carrier The carrier of a shipment
     * @return the easy tracker object
     */
    EasyTracker createEasyTrackerByTrackingCode(String trackingCode, String carrier);

    /**
     *
     * @param trackingCode The code of a shipment
     * @return The easy tracker object
     */
    EasyTracker getEasyTrackerByTrackingCode(String trackingCode);

    /**
     *
     * @param trackingCode The code of a shipment
     * @return the tracking details list
     */
    List<EasyTrackingDetail> getTrackingDetailsByTrackingCode(String trackingCode);

}
