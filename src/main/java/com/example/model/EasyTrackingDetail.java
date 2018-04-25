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
}
