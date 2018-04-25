package com.example.model;



import java.util.List;

/**
 * @author garden
 * @create 4/23/18
 */
public class PacTrackUser {
    private String email;
    private String firebaseId;
    private List<EasyTracker> trackingHistory;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirebaseId() {
        return firebaseId;
    }

    public void setFirebaseId(String fireBaseId) {
        this.firebaseId = fireBaseId;
    }

    public List<EasyTracker> getTrcakingHistory() {
        return trackingHistory;
    }

    public void setTrcakingHistory(List<EasyTracker> trcakingHistory) {
        this.trackingHistory = trcakingHistory;
    }

    public PackTrackUserBuilder builder(){
        return new PackTrackUserBuilder();
    }
    // Make the constructor invisible
    private PacTrackUser(PackTrackUserBuilder packTrackUserBuilder){
        this.email = packTrackUserBuilder.email;
        this.firebaseId = packTrackUserBuilder.firebaseId;
        this.trackingHistory = packTrackUserBuilder.trackingHistory;
    }

    // Construct the builder
    public static class PackTrackUserBuilder{
        private String email;
        private List<EasyTracker> trackingHistory;
        private String firebaseId;


        public PackTrackUserBuilder withEmail(String email){
            this.email = email;
            return this;
        }
        public PackTrackUserBuilder withTrackingHistory(List<EasyTracker> trackingHistory){
            this.trackingHistory = trackingHistory;
            return this;
        }

        public PackTrackUserBuilder withFirebaseId(String firebaseId){
            this.firebaseId = firebaseId;
            return this;
        }

        public PacTrackUser build(){
            return new PacTrackUser(this);
        }
    }



}
