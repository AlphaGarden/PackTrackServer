package com.example.dao;

import com.easypost.model.Tracker;
import com.easypost.model.TrackingDetail;


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
    Tracker createTrackerByTrackingCodeAndCarrier(String trackingCode, String carrier);

    /**
     *
     * @param trackerId The id of tracker
     * @return The easy tracker object
     */
    Tracker getTrackerByTrackerId(String trackerId);

    /**
     *
     * @param trackerId The id of tracker
     * @return the tracking details list
     */
    List<TrackingDetail> getTrackingDetailsByTrackerId(String trackerId);

}
