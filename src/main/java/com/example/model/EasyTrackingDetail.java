package com.example.model;

/**
 * @author garden
 * @create 4/23/18
 */
public class EasyTrackingDetail {
    private String message; // Departed FedEx location
    private String status; // in_transit
    private String statusDetail; // departed_facility
    private String dateTime; //  2018-03-20T04:09:32Z
    private String city; // MEMPHIS
    private String state; // TN
    private String country; // US
    private String zip; // 38118

    private EasyTrackingDetail(TrackingDetailBuilder builder){
        this.message = builder.message;
        this.status = builder.status;
        this.statusDetail = builder.statusDetail;
        this.dateTime = builder.dateTime;
        this.city = builder.city;
        this.state = builder.state;
        this.country = builder.country;
        this.zip = builder.zip;
    }

    public static TrackingDetailBuilder builder(){
        return new TrackingDetailBuilder();
    }

    public static class TrackingDetailBuilder{
        private String message; // Departed FedEx location
        private String status; // in_transit
        private String statusDetail; // departed_facility
        private String dateTime; //  2018-03-20T04:09:32Z
        private String city; // MEMPHIS
        private String state; // TN
        private String country; // US
        private String zip; // 38118

        public TrackingDetailBuilder() {}

        public TrackingDetailBuilder withMessage(String message){
            this.message = message;
            return this;
        }

        public TrackingDetailBuilder withStatus(String status){
            this.status = status;
            return this;
        }

        public TrackingDetailBuilder withStatusDetail(String statusDetail){
            this.statusDetail = statusDetail;
            return this;
        }

        public TrackingDetailBuilder withDateTime(String dateTime){
            this.dateTime = dateTime;
            return this;
        }

        public TrackingDetailBuilder withCity(String city){
            this.city = city;
            return this;
        }

        public TrackingDetailBuilder withState(String state){
            this.state = state;
            return this;
        }

        public TrackingDetailBuilder withCountry(String country){
            this.country = country;
            return this;
        }

        public TrackingDetailBuilder withZip(String zip){
            this.zip = zip;
            return this;
        }

        public EasyTrackingDetail build(){
            return new EasyTrackingDetail(this);
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusDetail() {
        return statusDetail;
    }

    public void setStatusDetail(String statusDetail) {
        this.statusDetail = statusDetail;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
