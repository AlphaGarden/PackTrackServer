package com.example.dao;

import com.easypost.model.Tracker;
import java.util.List;

/**
 * @author garden
 * @create 4/23/18
 */
public interface TrackingDaoInterface {

    /**
     * Insert the record <userId, trackers> into the firebase database
     * @param userId the user Identification
     * @param trackerId The tracker Id derived from easypostdao
     */
    void insert(String userId, String trackerId);

    /**
     * Ensure that per tracking code only corresponds to only one trackerId
     *
     * @param trackingCode The tracking code of a shipment "Z0000000001"
     * @param carrier The carrier of the shipment
     * @param trackerId The tracker id of a easy post tracker "trk_012bsdkfjkashd123"
     */
    void insert(String trackingCode, String carrier, String trackerId);

    /**
     * To isolated the tracker object from the user, as per user probably can have multiple tracker
     *
     * @param trackingId The tracker id of a easy post tracker "trk_012bsdkfjkashd123"
     * @param tracker The tracker object
     */
    void insert(String trackingId, Tracker tracker);

    /**
     * Update the tracker by its tracking id.
     *
     * @param trackerId The tracker
     * @param newTracker The Updated Easy post Tracker Object.
     */
    void updateTrackerByTrackerId(String trackerId, Tracker newTracker);

    /**
     * To get all the trackers related with current users.
     *
     * @param userId The user Identity number.
     * @return All Trackers under the user ID given.
     */
    List<Tracker> getAllTrackers(String userId);

    /**
     * To get all user IDs related with this tracker id
     *
     * @param trackerId The tracker id of a shipment
     * @return the user id list who has queried that tracking number in their history
     */
    List<String> getAllUserIdsByTrackerId(String trackerId);

    /**
     *
     * To get all emails related with this tracker id
     *
     * @param trackerId The tracker id of a shipment
     * @return the email list
     */
    List<String> getEmailsByTrackerId(String trackerId);

    /**
     * To get the trackerId by tracking code and its carrier.
     *
     * @param trackingCode The tracking code of a shipment
     * @param carrier The carrier of the shipment
     * @return The corresponding tracker id of that tracking code.
     */
    String getTrackerIdByTrackingCodeAndCarrier(String trackingCode, String carrier);

    /**
     * To get the tracker object from the database  by its tracker id
     *
     * @param trackingId The tracking id like "trk_012bsdkfjkashd123"
     * @return The specific Tracker  its tracker id.
     */
    Tracker getOneTracker(String trackingId);



}
