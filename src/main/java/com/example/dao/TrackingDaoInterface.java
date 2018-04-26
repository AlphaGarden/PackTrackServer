package com.example.dao;

import com.easypost.model.TrackingDetail;
import com.example.model.EasyTracker;

import java.util.List;

/**
 * @author garden
 * @create 4/23/18
 */
public interface TrackingDaoInterface {

    /**
     *
     * @param userId The user Identity number.
     * @param tracker The object need to be inserted in to database.
     */
    void insert(String userId, EasyTracker tracker);

    /**
     *
     * @param userId The user Identity number.
     * @return All EasyTrackers under the user ID given.
     */
    List<EasyTracker> getAllEasyTracker(String userId);

    /**
     *
     * @param userId The user Identity number.
     * @param trackingNumber The code like "Z10000000001".
     * @return The specific EasyTracker by the user id and its tracking number.
     */
    EasyTracker getOneTracker(String userId, String trackingNumber);


    /**
     * Append the updated shipment information
     *
     * @param userId The user Identity number.
     * @param trackingNumber The Tracking Number.
     * @param newEasyTracker The Updated Easy Tracker Object.
     */
    void updateTrackingInfo(String userId, String trackingNumber, EasyTracker newEasyTracker);

}
