package com.example.dao;

import com.easypost.model.Tracker;
import com.example.error.FirebaseException;
import com.example.error.JacksonUtilityException;
import com.example.model.PacTrackUser;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author garden
 * @create 4/23/18
 */
public interface TrackingDaoInterface {

    /**
     * Insert the record <userId, trackers> into the firebase database
     * @param userId The user Identity number.
     * @param trackers The trackers was search ny users.
     */
    void insert(String userId, List<Tracker> trackers) throws JacksonUtilityException, UnsupportedEncodingException, FirebaseException;

    /**
     * Ensure that per tracking code only corresponds to only one trackerId
     *
     * @param trackingCode The tracking code of a shipment "Z0000000001"
     * @param trackerId The tracker id of a easy post tracker "trk_012bsdkfjkashd123"
     */
    void insert(String trackingCode, String trackerId) throws JacksonUtilityException, FirebaseException, UnsupportedEncodingException;

    /**
     *
     * @param userId The user Identity number.
     * @return All EasyTrackers under the user ID given.
     */
    List<Tracker> getAllTrackers(String userId) throws JacksonUtilityException, FirebaseException, UnsupportedEncodingException;

    /**
     *
     * @param trackingCode The tracking code of a shipment
     * @return the user lists who have that tracking number in their history
     */
    List<PacTrackUser> getAllUsersByTrackingCode(String trackingCode);


    /**
     *
     * @param trackingCode The tracking code of a shipment
     * @return The corresponding tracker id of that tracking code.
     */
    String getTrackerIdByTrackingCode(String trackingCode);

    /**
     *
     * @param userId The user Identity number.
     * @param trackingCode The code like "Z10000000001".
     * @return The specific EasyTracker by the user id and its tracking number.
     */
    Tracker getOneTracker(String userId, String trackingCode);


    /**
     * Append the updated shipment
     *
     * @param trackingCode The Tracking Number.
     * @param newTracker The Updated Easy post Tracker Object.
     */
    void updateTrackingInfo(String trackingCode, Tracker newTracker);


}
