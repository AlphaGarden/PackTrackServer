package com.example.dao;

import com.easypost.model.Tracker;
import com.example.model.EasyTracker;
import com.example.model.PacTrackUser;

import java.util.List;

/**
 * @author garden
 * @create 4/26/18
 */
public class TrackingDao implements TrackingDaoInterface {


    @Override
    public void insert(String userId, String trackerId) {

    }

    @Override
    public void insert(String trackingCode, String carrier, String trackerId) {

    }

    @Override
    public void insert(String trackingId, Tracker tracker) {

    }

    @Override
    public void updateTrackerByTrackerId(String trackerId, Tracker newTracker) {

    }

    @Override
    public List<Tracker> getAllTrackers(String userId) {
        return null;
    }

    @Override
    public List<String> getAllUserIdsByTrackerId(String trackerId) {
        return null;
    }

    @Override
    public List<String> getEmailsByTrackerId(String trackerId) {
        return null;
    }

    @Override
    public String getTrackerIdByTrackingCodeAndCarrier(String trackingCode, String carrier) {
        return null;
    }

    @Override
    public Tracker getOneTracker(String trackingId) {
        return null;
    }
}
