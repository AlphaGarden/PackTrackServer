package com.example.model;

import com.easypost.model.Tracker;

/**
 * @author garden
 * @create 4/16/18
 */
public class CloudMessage {
    private String toClient; // The Client ID
    private Tracker tracker; // The message body

    private CloudMessage(CloudMessageBuilder builder){
        this.toClient = builder.toClient;
        this.tracker = builder.tracker;
    }

    public static CloudMessageBuilder builder(){
        return new CloudMessageBuilder();
    }

    public static class CloudMessageBuilder{
        private String toClient; // The Client ID
        private Tracker tracker; // The message body

        public CloudMessageBuilder withToClient(String toClient){
            this.toClient = toClient;
            return this;
        }

        public CloudMessageBuilder withTracker(Tracker newTracker){
            this.tracker = newTracker;
            return this;
        }

        public CloudMessage build(){
            return new CloudMessage(this);
        }
    }

    public String getToClient() {
        return toClient;
    }

    public void setToClient(String toClient) {
        this.toClient = toClient;
    }

    public Tracker getTracker() {
        return tracker;
    }

    public void setTracker(Tracker tracker) {
        this.tracker = tracker;
    }
}
