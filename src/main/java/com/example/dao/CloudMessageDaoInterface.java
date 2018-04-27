package com.example.dao;

import com.example.model.CloudMessage;
import com.example.model.PacTrackUser;

/**
 * @author garden
 * @create 4/25/18
 */
public interface CloudMessageDaoInterface {
    /**
     *
     * send the notification message to GCM Connection Server
     * @param message The the Message boy need to
     */
    void send(CloudMessage message);
}
