package com.example.dao;

import com.easypost.model.Tracker;
import com.example.helper.TestHelper;


import java.util.List;

/**
 * @author garden
 * @create 4/26/18
 */
public class TrackingDao implements TrackingDaoInterface {
    private static TestHelper testHelper = TestHelper.getHelper();

    @Override
    public void insert(String userId, String trackerId) {
        System.out.println("Insert operation " + userId+ " : " +trackerId);
    }

    @Override
    public void insert(String trackingCode, String carrier, String trackerId) {
        System.out.println("Insert operation " + trackingCode + " : " + carrier + " : " +trackerId);
    }

    @Override
    public void insert(String trackingId, Tracker tracker) {
        System.out.println("Insert operation " + trackingId+ " : " + tracker);
    }

    @Override
    public void deleteTrackerById(String userId, String trackerId) {
        System.out.println("Delete operation " + userId+ " : " +trackerId);
    }

    @Override
    public void updateTrackerByTrackerId(String trackerId, Tracker newTracker) {
        System.out.println ("Update operation " + trackerId + " : " + newTracker);
    }

    @Override
    public List<Tracker> getAllTrackers(String userId) {
        return testHelper.getTrackerList();
    }

    @Override
    public List<String> getAllUserIdsByTrackerId(String trackerId) {
        return testHelper.getUserIdlist();
    }

    @Override
    public List<String> getEmailsByTrackerId(String trackerId) {
        return testHelper.getEmailList();
    }

    @Override
    public String getTrackerIdByTrackingCodeAndCarrier(String trackingCode, String carrier) {
        return testHelper.getTrackerOneObj().getId();
    }

    @Override
    public Tracker getOneTracker(String trackingId) {
        return testHelper.getTrackerOneObj();
    }
}
