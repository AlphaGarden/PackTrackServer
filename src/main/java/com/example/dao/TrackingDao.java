package com.example.dao;

import com.example.model.EasyTracker;
import com.example.model.PacTrackUser;

import java.util.List;

/**
 * @author garden
 * @create 4/26/18
 */
public class TrackingDao implements TrackingDaoInterface {
    @Override
    public void insert(String userId, EasyTracker tracker) { }

    @Override
    public void insert(String trackingCode, String trackerId) {

    }

    @Override
    public List<EasyTracker> getAllEasyTracker(String userId) {
        return null;
    }

    @Override
    public List<PacTrackUser> getAllUsersByTrackingCode(String trackingCode) {
        return null;
    }


    @Override
    public String getTrackerIdByTrackingCode(String trackingCode) {
        return null;
    }

    @Override
    public EasyTracker getOneTracker(String userId, String trackingCode) {
        return null;
    }

    @Override
    public void updateTrackingInfo(String userId, String trackingCode, EasyTracker newEasyTracker) {

    }
}
