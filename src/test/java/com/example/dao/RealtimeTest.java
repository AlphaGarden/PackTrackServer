package com.example.dao;

import com.easypost.model.Tracker;
import com.example.error.FirebaseException;
import com.example.error.JacksonUtilityException;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class RealtimeTest {

    public static void main(String[] args) throws JacksonUtilityException, FirebaseException, UnsupportedEncodingException {

        //test insert(String userId, String trackerId)
        String user1 = "user1";
        String trackerId1 = "trk_012bsdkfjkashd123";
        String user2 = "user2";
        String trackerId2 = "trk_012bsdkfjkashd111";
        TrackingDao trackingDao1 = new TrackingDao();
        trackingDao1.insert(user1, trackerId1);
        trackingDao1.insert(user1, trackerId2);
        trackingDao1.insert(user2, trackerId2);

        //test insert(String trackingCode, String carrier, String trackerId)
        String trackingCode1 = "Z0000000001";
        String carrier1 = "Fedex";
        String trackingCode2 = "Z0000000002";
        String carrier2 = "Ups";
        trackingDao1.insert(trackingCode1, carrier1, trackerId1);
        trackingDao1.insert(trackingCode2, carrier2, trackerId2);

        //test insert(String trackingId, Tracker tracker)
        Tracker tracker1 = new Tracker();
        tracker1.setId(trackerId1);
        tracker1.setCarrier(carrier1);
        tracker1.setStatus("On the way");
        Tracker tracker2 = new Tracker();
        tracker2.setId(trackerId2);
        tracker2.setCarrier(carrier2);
        tracker2.setStatus("Delivered");
        trackingDao1.insert(trackerId1, tracker1);
        trackingDao1.insert(trackerId2, tracker2);

        //test deleteTrackerById(String userId, String trackerId)
        //trackingDao1.deleteTrackerById(user1, trackerId1);

        //test updateTrackerByTrackerId(String trackerId, Tracker newTracker)
        trackingDao1.updateTrackerByTrackerId(trackerId1, tracker2);

        //test getAllTrackers(String userId)
        List<Tracker> list = trackingDao1.getAllTrackers(user1);

        //test getAllUserIdsByTrackerId(String trackerId)
        List<String> list2 = trackingDao1.getAllUserIdsByTrackerId("trk_012bsdkfjkashd111");

        //test getTrackerIdByTrackingCodeAndCarrier(String trackingCode, String carrier)
        String trackerId = trackingDao1.getTrackerIdByTrackingCodeAndCarrier("Z0000000001", "Fedex");

        //test getOneTracker(String trackingId)
        Tracker t = trackingDao1.getOneTracker(trackerId1);
        return;
    }
}
