package com.example.model;

import java.util.List;

/**
 * @author garden
 * @create 4/29/18
 */
public class TrackingRecord {
    String TrackingCode;
    String Carrier;
    String lastUpdatedAt;

    public TrackingRecord(String trackingCode, String carrier, String lastUpdatedAt) {
        TrackingCode = trackingCode;
        Carrier = carrier;
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public String getTrackingCode() {
        return TrackingCode;
    }

    public void setTrackingCode(String trackingCode) {
        TrackingCode = trackingCode;
    }

    public String getCarrier() {
        return Carrier;
    }

    public void setCarrier(String carrier) {
        Carrier = carrier;
    }

    public String getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(String lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }
}
