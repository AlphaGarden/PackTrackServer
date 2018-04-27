package com.example.model;

import java.util.List;

/**
 * @author garden
 * @create 4/23/18
 */
public class EasyTracker {
    private String trackerId;
    private String trackingCode;
    private String upToDateStatus;
    private String estDeliveryDate;
    private String updateAt;
    private String carrier;
    private List<EasyTrackingDetail> easyTrackingDetails;

    private EasyTracker(EasyTrackerBuilder builder){
        this.trackerId = builder.trackerId;
        this.trackingCode = builder.trackingCode;
        this.upToDateStatus = builder.upToDateStatus;
        this.estDeliveryDate = builder.estDeliveryDate;
        this.updateAt = builder.updateAt;
        this.carrier = builder.carrier;
        this.easyTrackingDetails = builder.easyTrackingDetails;
    }


    public static EasyTrackerBuilder builder(){
        return new EasyTrackerBuilder();
    }

    public static class EasyTrackerBuilder{
        private String trackerId;
        private String trackingCode;
        private String upToDateStatus;
        private String estDeliveryDate;
        private String updateAt;
        private String carrier;
        private List<EasyTrackingDetail> easyTrackingDetails;


        public EasyTrackerBuilder withTrackerId(String trackerId){
            this.trackerId = trackerId;
            return this;
        }

        public EasyTrackerBuilder withTrackingCode(String trackingCode){
            this.trackingCode = trackingCode;
            return this;
        }

        public EasyTrackerBuilder withUpToDateStatus(String upToDateStatus){
            this.upToDateStatus = upToDateStatus;
            return this;
        }

        public EasyTrackerBuilder withEstDeliveryDate(String estDeliveryDate){
            this.estDeliveryDate = estDeliveryDate;
            return this;
        }

        public EasyTrackerBuilder withUpdateAt(String updateAt){
            this.updateAt = updateAt;
            return this;
        }

        public EasyTrackerBuilder withCarrier(String carrier){
            this.carrier = carrier;
            return this;
        }

        public EasyTrackerBuilder withEasyTrackingDetails(List<EasyTrackingDetail> easyTrackingDetails){
            this.easyTrackingDetails = easyTrackingDetails;
            return this;
        }

        public EasyTracker build(){
            return (new EasyTracker(this));
        }
    }

    public String getTrackerId() {
        return trackerId;
    }

    public void setTrackerId(String trackerId) {
        this.trackerId = trackerId;
    }

    public String getTrackingCode() {
        return trackingCode;
    }

    public void setTrackingCode(String trackingCode) {
        this.trackingCode = trackingCode;
    }

    public String getUpToDateStatus() {
        return upToDateStatus;
    }

    public void setUpToDateStatus(String upToDateStatus) {
        this.upToDateStatus = upToDateStatus;
    }

    public String getEstDeliveryDate() {
        return estDeliveryDate;
    }

    public void setEstDeliveryDate(String estDeliveryDate) {
        this.estDeliveryDate = estDeliveryDate;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public List<EasyTrackingDetail> getEasyTrackingDetails() {
        return easyTrackingDetails;
    }

    public void setEasyTrackingDetails(List<EasyTrackingDetail> easyTrackingDetails) {
        this.easyTrackingDetails = easyTrackingDetails;
    }

    @Override
    public String toString() {
        return "EasyTracker{" +
                "trackerId='" + trackerId + '\'' +
                ", trackingCode='" + trackingCode + '\'' +
                ", upToDateStatus='" + upToDateStatus + '\'' +
                ", estDeliveryDate='" + estDeliveryDate + '\'' +
                ", updateAt='" + updateAt + '\'' +
                ", carrier='" + carrier + '\'' +
                ", easyTrackingDetails=" + easyTrackingDetails +
                '}';
    }
}
