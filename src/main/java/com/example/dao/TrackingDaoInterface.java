package com.example.dao;

import com.easypost.model.TrackingDetail;
import com.example.model.EasyTracker;
import com.example.model.PacTrackUser;

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
     * @param trackingCode The tracking number
     * @return the user lists who have that tracking number in their history
     */
    List<PacTrackUser> getAllUsersByTrackingNumber(String trackingCode);

    /**
     *
     * @param userId The user Identity number.
     * @param trackingCode The code like "Z10000000001".
     * @return The specific EasyTracker by the user id and its tracking number.
     */
    EasyTracker getOneTracker(String userId, String trackingCode);


    /**
     * Append the updated shipment information
     *
     * @param userId The user Identity number.
     * @param trackingCode The Tracking Number.
     * @param newEasyTracker The Updated Easy Tracker Object.
     */
    void updateTrackingInfo(String userId, String trackingCode, EasyTracker newEasyTracker);


}
