package com.example.helper;


import com.easypost.model.Event;
import com.easypost.model.Tracker;
import com.example.dao.EasyPostDao;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author garden
 * @create 4/30/18
 */
public class TestHelper {
    private final String userOneId = "FireBaseID001";
    private final String userOneEmail = "1419286710@qq.com";
    private final String userTwoId = "FireBaseID002";
    private final String userTweoEmail = "313016129@qq.com";
    private final String userThreeId = "FireBaseId003";
    private final String userThreeEmail = "jiayongm@asu.edu";

    private final String eventJson = "{\"result\":{\"id\":\"trk_9d408ea9fce64e8e9cbfce35d2d69b55\",\"object\":\"Tracker\",\"mode\":\"test\",\"tracking_code\":\"EZ5000000005\",\"status\":\"return_to_sender\",\"status_detail\":\"return\",\"created_at\":\"2018-04-18T19:18:32Z\",\"updated_at\":\"2018-04-18T19:18:32Z\",\"signed_by\":null,\"weight\":17.6,\"est_delivery_date\":\"2018-04-18T19:18:32Z\",\"shipment_id\":null,\"carrier\":\"FedEx\",\"tracking_details\":[{\"object\":\"TrackingDetail\",\"message\":\"Shipment information sent to FedEx\",\"description\":null,\"status\":\"pre_transit\",\"status_detail\":\"status_update\",\"datetime\":\"2018-03-19T09:42:32Z\",\"source\":\"FedEx\",\"carrier_code\":null,\"tracking_location\":{\"object\":\"TrackingLocation\",\"city\":null,\"state\":null,\"country\":null,\"zip\":null}},{\"object\":\"TrackingDetail\",\"message\":\"Picked up\",\"description\":null,\"status\":\"in_transit\",\"status_detail\":\"arrived_at_facility\",\"datetime\":\"2018-03-19T10:06:32Z\",\"source\":\"FedEx\",\"carrier_code\":null,\"tracking_location\":{\"object\":\"TrackingLocation\",\"city\":\"NEW YORK\",\"state\":\"NY\",\"country\":\"US\",\"zip\":\"10014\"}},{\"object\":\"TrackingDetail\",\"message\":\"Departed FedEx location\",\"description\":null,\"status\":\"in_transit\",\"status_detail\":\"departed_facility\",\"datetime\":\"2018-03-20T04:09:32Z\",\"source\":\"FedEx\",\"carrier_code\":null,\"tracking_location\":{\"object\":\"TrackingLocation\",\"city\":\"MEMPHIS\",\"state\":\"TN\",\"country\":\"US\",\"zip\":\"38118\"}},{\"object\":\"TrackingDetail\",\"message\":\"At destination sort facility\",\"description\":null,\"status\":\"in_transit\",\"status_detail\":\"arrived_at_facility\",\"datetime\":\"2018-03-21T04:49:32Z\",\"source\":\"FedEx\",\"carrier_code\":null,\"tracking_location\":{\"object\":\"TrackingLocation\",\"city\":\"ATLANTA\",\"state\":\"GA\",\"country\":\"US\",\"zip\":\"30320\"}},{\"object\":\"TrackingDetail\",\"message\":\"At local FedEx facility\",\"description\":null,\"status\":\"in_transit\",\"status_detail\":\"arrived_at_facility\",\"datetime\":\"2018-03-21T09:42:32Z\",\"source\":\"FedEx\",\"carrier_code\":null,\"tracking_location\":{\"object\":\"TrackingLocation\",\"city\":\"MARIETTA\",\"state\":\"GA\",\"country\":\"US\",\"zip\":\"30067\"}},{\"object\":\"TrackingDetail\",\"message\":\"On FedEx vehicle for delivery\",\"description\":null,\"status\":\"out_for_delivery\",\"status_detail\":\"out_for_delivery\",\"datetime\":\"2018-03-22T03:28:32Z\",\"source\":\"FedEx\",\"carrier_code\":null,\"tracking_location\":{\"object\":\"TrackingLocation\",\"city\":\"MARIETTA\",\"state\":\"GA\",\"country\":\"US\",\"zip\":\"30067\"}},{\"object\":\"TrackingDetail\",\"message\":\"Address Does Not Exist - Returning to Sender\",\"description\":null,\"status\":\"return_to_sender\",\"status_detail\":\"return\",\"datetime\":\"2018-03-22T10:51:32Z\",\"source\":\"FedEx\",\"carrier_code\":null,\"tracking_location\":{\"object\":\"TrackingLocation\",\"city\":\"ATLANTA\",\"state\":\"GA\",\"country\":\"US\",\"zip\":\"30320\"}}],\"carrier_detail\":{\"object\":\"CarrierDetail\",\"service\":\"FEDEX_GROUND\",\"container_type\":\"YOUR_PACKAGING\",\"est_delivery_date_local\":\"2875-10-22\",\"est_delivery_time_local\":\"19:18:32\",\"origin_location\":\"NEW YORK NY US\",\"origin_tracking_location\":{\"object\":\"TrackingLocation\",\"city\":\"NEW YORK\",\"state\":\"NY\",\"country\":\"US\",\"zip\":\"10014\"},\"destination_location\":\"ATLANTA GA US\",\"destination_tracking_location\":null,\"guaranteed_delivery_date\":null,\"alternate_identifier\":null,\"initial_delivery_attempt\":\"2018-03-22T10:51:32Z\"},\"finalized\":true,\"is_return\":false,\"public_url\":\"https://track.easypost.com/djE6dHJrXzlkNDA4ZWE5ZmNlNjRlOGU5Y2JmY2UzNWQyZDY5YjU1\",\"fees\":[{\"object\":\"Fee\",\"type\":\"TrackerFee\",\"amount\":\"0.00000\",\"charged\":false,\"refunded\":false}]},\"description\":\"tracker.updated\",\"mode\":\"test\",\"previous_attributes\":{\"status\":\"return_to_sender\"},\"created_at\":\"2018-04-18T19:19:32Z\",\"pending_urls\":[\"https://20180418t112515-dot-packtrack-200423.appspot.com\"],\"completed_urls\":[],\"updated_at\":\"2018-04-18T19:19:32Z\",\"id\":\"evt_25a41bcd3af34544a93695b500778d67\",\"user_id\":\"user_f9994d7e43604b8494c1b1ebe19a6815\",\"status\":\"in_queue\",\"object\":\"Event\"}";
    private final String trackerJsonOne = "{\"id\":\"trk_9d408ea9fce64e8e9cbfce35d2d69b55\",\"object\":\"Tracker\",\"mode\":\"test\",\"tracking_code\":\"EZ5000000005\",\"status\":\"return_to_sender\",\"status_detail\":\"return\",\"created_at\":\"2018-04-18T19:18:32Z\",\"updated_at\":\"2018-04-18T19:18:32Z\",\"signed_by\":null,\"weight\":17.6,\"est_delivery_date\":\"2018-04-18T19:18:32Z\",\"shipment_id\":null,\"carrier\":\"FedEx\",\"tracking_details\":[{\"object\":\"TrackingDetail\",\"message\":\"Shipment information sent to FedEx\",\"description\":null,\"status\":\"pre_transit\",\"status_detail\":\"status_update\",\"datetime\":\"2018-03-19T09:42:32Z\",\"source\":\"FedEx\",\"carrier_code\":null,\"tracking_location\":{\"object\":\"TrackingLocation\",\"city\":null,\"state\":null,\"country\":null,\"zip\":null}},{\"object\":\"TrackingDetail\",\"message\":\"Picked up\",\"description\":null,\"status\":\"in_transit\",\"status_detail\":\"arrived_at_facility\",\"datetime\":\"2018-03-19T10:06:32Z\",\"source\":\"FedEx\",\"carrier_code\":null,\"tracking_location\":{\"object\":\"TrackingLocation\",\"city\":\"NEW YORK\",\"state\":\"NY\",\"country\":\"US\",\"zip\":\"10014\"}},{\"object\":\"TrackingDetail\",\"message\":\"Departed FedEx location\",\"description\":null,\"status\":\"in_transit\",\"status_detail\":\"departed_facility\",\"datetime\":\"2018-03-20T04:09:32Z\",\"source\":\"FedEx\",\"carrier_code\":null,\"tracking_location\":{\"object\":\"TrackingLocation\",\"city\":\"MEMPHIS\",\"state\":\"TN\",\"country\":\"US\",\"zip\":\"38118\"}},{\"object\":\"TrackingDetail\",\"message\":\"At destination sort facility\",\"description\":null,\"status\":\"in_transit\",\"status_detail\":\"arrived_at_facility\",\"datetime\":\"2018-03-21T04:49:32Z\",\"source\":\"FedEx\",\"carrier_code\":null,\"tracking_location\":{\"object\":\"TrackingLocation\",\"city\":\"ATLANTA\",\"state\":\"GA\",\"country\":\"US\",\"zip\":\"30320\"}},{\"object\":\"TrackingDetail\",\"message\":\"At local FedEx facility\",\"description\":null,\"status\":\"in_transit\",\"status_detail\":\"arrived_at_facility\",\"datetime\":\"2018-03-21T09:42:32Z\",\"source\":\"FedEx\",\"carrier_code\":null,\"tracking_location\":{\"object\":\"TrackingLocation\",\"city\":\"MARIETTA\",\"state\":\"GA\",\"country\":\"US\",\"zip\":\"30067\"}},{\"object\":\"TrackingDetail\",\"message\":\"On FedEx vehicle for delivery\",\"description\":null,\"status\":\"out_for_delivery\",\"status_detail\":\"out_for_delivery\",\"datetime\":\"2018-03-22T03:28:32Z\",\"source\":\"FedEx\",\"carrier_code\":null,\"tracking_location\":{\"object\":\"TrackingLocation\",\"city\":\"MARIETTA\",\"state\":\"GA\",\"country\":\"US\",\"zip\":\"30067\"}},{\"object\":\"TrackingDetail\",\"message\":\"Address Does Not Exist - Returning to Sender\",\"description\":null,\"status\":\"return_to_sender\",\"status_detail\":\"return\",\"datetime\":\"2018-03-22T10:51:32Z\",\"source\":\"FedEx\",\"carrier_code\":null,\"tracking_location\":{\"object\":\"TrackingLocation\",\"city\":\"ATLANTA\",\"state\":\"GA\",\"country\":\"US\",\"zip\":\"30320\"}}],\"carrier_detail\":{\"object\":\"CarrierDetail\",\"service\":\"FEDEX_GROUND\",\"container_type\":\"YOUR_PACKAGING\",\"est_delivery_date_local\":\"2875-10-22\",\"est_delivery_time_local\":\"19:18:32\",\"origin_location\":\"NEW YORK NY US\",\"origin_tracking_location\":{\"object\":\"TrackingLocation\",\"city\":\"NEW YORK\",\"state\":\"NY\",\"country\":\"US\",\"zip\":\"10014\"},\"destination_location\":\"ATLANTA GA US\",\"destination_tracking_location\":null,\"guaranteed_delivery_date\":null,\"alternate_identifier\":null,\"initial_delivery_attempt\":\"2018-03-22T10:51:32Z\"},\"finalized\":true,\"is_return\":false,\"public_url\":\"https://track.easypost.com/djE6dHJrXzlkNDA4ZWE5ZmNlNjRlOGU5Y2JmY2UzNWQyZDY5YjU1\",\"fees\":[{\"object\":\"Fee\",\"type\":\"TrackerFee\",\"amount\":\"0.00000\",\"charged\":false,\"refunded\":false}]}";
    private final String trackerJsonTwo = "{\"id\":\"trk_e916ebcd61ad4e34beb9fcbf06ab4453\",\"object\":\"Tracker\",\"mode\":\"test\",\"tracking_code\":\"EZ1000000001\",\"status\":\"pre_transit\",\"status_detail\":\"status_update\",\"created_at\":\"2018-04-16T06:39:46Z\",\"updated_at\":\"2018-04-16T06:39:47Z\",\"signed_by\":null,\"weight\":17.6,\"est_delivery_date\":\"2018-04-16T06:39:47Z\",\"shipment_id\":null,\"carrier\":\"FedEx\",\"tracking_details\":[{\"object\":\"TrackingDetail\",\"message\":\"Shipment information sent to FedEx\",\"description\":null,\"status\":\"pre_transit\",\"status_detail\":\"status_update\",\"datetime\":\"2018-03-16T21:03:47Z\",\"source\":\"FedEx\",\"carrier_code\":null,\"tracking_location\":{\"object\":\"TrackingLocation\",\"city\":null,\"state\":null,\"country\":null,\"zip\":null}}],\"carrier_detail\":{\"object\":\"CarrierDetail\",\"service\":\"FEDEX_GROUND\",\"container_type\":\"YOUR_PACKAGING\",\"est_delivery_date_local\":\"2875-10-20\",\"est_delivery_time_local\":\"06:39:47\",\"origin_location\":\"NEW YORK NY US\",\"origin_tracking_location\":null,\"destination_location\":\"ATLANTA GA US\",\"destination_tracking_location\":null,\"guaranteed_delivery_date\":null,\"alternate_identifier\":null,\"initial_delivery_attempt\":null},\"finalized\":true,\"is_return\":false,\"public_url\":\"https://track.easypost.com/djE6dHJrX2U5MTZlYmNkNjFhZDRlMzRiZWI5ZmNiZjA2YWI0NDUz\",\"fees\":[{\"object\":\"Fee\",\"type\":\"TrackerFee\",\"amount\":\"0.00000\",\"charged\":false,\"refunded\":false}]}";
    private final String trackerJsonThree = "{\"id\":\"trk_9fd22cf3a4244db9ad9714da2cdf374f\",\"object\":\"Tracker\",\"mode\":\"test\",\"tracking_code\":\"EZ4000000004\",\"status\":\"delivered\",\"status_detail\":\"arrived_at_destination\",\"created_at\":\"2018-04-17T21:49:36Z\",\"updated_at\":\"2018-04-17T21:49:36Z\",\"signed_by\":\"John Tester\",\"weight\":17.6,\"est_delivery_date\":\"2018-04-17T21:49:36Z\",\"shipment_id\":null,\"carrier\":\"FedEx\",\"tracking_details\":[{\"object\":\"TrackingDetail\",\"message\":\"Shipment information sent to FedEx\",\"description\":null,\"status\":\"pre_transit\",\"status_detail\":\"status_update\",\"datetime\":\"2018-03-18T12:13:36Z\",\"source\":\"FedEx\",\"carrier_code\":null,\"tracking_location\":{\"object\":\"TrackingLocation\",\"city\":null,\"state\":null,\"country\":null,\"zip\":null}},{\"object\":\"TrackingDetail\",\"message\":\"Picked up\",\"description\":null,\"status\":\"in_transit\",\"status_detail\":\"arrived_at_facility\",\"datetime\":\"2018-03-18T12:37:36Z\",\"source\":\"FedEx\",\"carrier_code\":null,\"tracking_location\":{\"object\":\"TrackingLocation\",\"city\":\"NEW YORK\",\"state\":\"NY\",\"country\":\"US\",\"zip\":\"10014\"}},{\"object\":\"TrackingDetail\",\"message\":\"Departed FedEx location\",\"description\":null,\"status\":\"in_transit\",\"status_detail\":\"departed_facility\",\"datetime\":\"2018-03-19T06:40:36Z\",\"source\":\"FedEx\",\"carrier_code\":null,\"tracking_location\":{\"object\":\"TrackingLocation\",\"city\":\"MEMPHIS\",\"state\":\"TN\",\"country\":\"US\",\"zip\":\"38118\"}},{\"object\":\"TrackingDetail\",\"message\":\"At destination sort facility\",\"description\":null,\"status\":\"in_transit\",\"status_detail\":\"arrived_at_facility\",\"datetime\":\"2018-03-20T07:20:36Z\",\"source\":\"FedEx\",\"carrier_code\":null,\"tracking_location\":{\"object\":\"TrackingLocation\",\"city\":\"ATLANTA\",\"state\":\"GA\",\"country\":\"US\",\"zip\":\"30320\"}},{\"object\":\"TrackingDetail\",\"message\":\"At local FedEx facility\",\"description\":null,\"status\":\"in_transit\",\"status_detail\":\"arrived_at_facility\",\"datetime\":\"2018-03-20T12:13:36Z\",\"source\":\"FedEx\",\"carrier_code\":null,\"tracking_location\":{\"object\":\"TrackingLocation\",\"city\":\"MARIETTA\",\"state\":\"GA\",\"country\":\"US\",\"zip\":\"30067\"}},{\"object\":\"TrackingDetail\",\"message\":\"On FedEx vehicle for delivery\",\"description\":null,\"status\":\"out_for_delivery\",\"status_detail\":\"out_for_delivery\",\"datetime\":\"2018-03-21T05:59:36Z\",\"source\":\"FedEx\",\"carrier_code\":null,\"tracking_location\":{\"object\":\"TrackingLocation\",\"city\":\"MARIETTA\",\"state\":\"GA\",\"country\":\"US\",\"zip\":\"30067\"}},{\"object\":\"TrackingDetail\",\"message\":\"Delivered\",\"description\":null,\"status\":\"delivered\",\"status_detail\":\"arrived_at_destination\",\"datetime\":\"2018-03-21T13:22:36Z\",\"source\":\"FedEx\",\"carrier_code\":null,\"tracking_location\":{\"object\":\"TrackingLocation\",\"city\":\"ATLANTA\",\"state\":\"GA\",\"country\":\"US\",\"zip\":\"30320\"}}],\"carrier_detail\":{\"object\":\"CarrierDetail\",\"service\":\"FEDEX_GROUND\",\"container_type\":\"YOUR_PACKAGING\",\"est_delivery_date_local\":\"2875-10-21\",\"est_delivery_time_local\":\"21:49:36\",\"origin_location\":\"NEW YORK NY US\",\"origin_tracking_location\":{\"object\":\"TrackingLocation\",\"city\":\"NEW YORK\",\"state\":\"NY\",\"country\":\"US\",\"zip\":\"10014\"},\"destination_location\":\"ATLANTA GA US\",\"destination_tracking_location\":{\"object\":\"TrackingLocation\",\"city\":\"ATLANTA\",\"state\":\"GA\",\"country\":\"US\",\"zip\":\"30320\"},\"guaranteed_delivery_date\":null,\"alternate_identifier\":null,\"initial_delivery_attempt\":\"2018-03-21T13:22:36Z\"},\"finalized\":true,\"is_return\":false,\"public_url\":\"https://track.easypost.com/djE6dHJrXzlmZDIyY2YzYTQyNDRkYjlhZDk3MTRkYTJjZGYzNzRm\",\"fees\":[{\"object\":\"Fee\",\"type\":\"TrackerFee\",\"amount\":\"0.00000\",\"charged\":false,\"refunded\":false}]}";
    private static EasyPostDao easyPostDao;
    private static TestHelper helper;
    private static JsonConverter converter;

    public static TestHelper getHelper(){
        if (helper != null){
            return helper;
        }else{
            helper = new TestHelper();
            easyPostDao = EasyPostDao.getEasyPostDao();
            converter = JsonConverter.getConverter();
            return helper;
        }
    }

    public String getEventJson() {
        return eventJson;
    }
    public Event getEventObj(){
        return converter.convertFromJsonString(eventJson, Event.class);
    }

    public String getTrackerJsonOne() {
        return trackerJsonOne;
    }

    public Tracker getTrackerOneObj(){
        String trackerId = "trk_e3e8d1c287c74fe0bd70598ab779317f";
        return easyPostDao.getTrackerByTrackerId(trackerId);
    }

    public String getTrackerJsonTwo() {
        return trackerJsonTwo;
    }

    public Tracker getTrackerTwoObj(){
        return converter.convertFromJsonString(trackerJsonTwo, Tracker.class);
    }

    public String getTrackerJsonThree() {
        return trackerJsonThree;
    }

    public Tracker getTrackerThreeObj(){
        return converter.convertFromJsonString(trackerJsonThree, Tracker.class);
    }

    public List<Tracker> getTrackerList(){
        List<Tracker> tracks = new LinkedList<>();
        tracks.add(getTrackerOneObj());
        tracks.add(getTrackerTwoObj());
        tracks.add(getTrackerThreeObj());
        return tracks;
    }

    public List<String> getUserIdlist(){
        List<String> userIds = new LinkedList<>();
        userIds.add(userOneId);
        userIds.add(userTwoId);
        userIds.add(userThreeId);
        return userIds;
    }

    public List<String> getEmailList(){
        List<String> emails = new ArrayList<>();
        emails.add(userOneEmail);
        emails.add(userTweoEmail);
        emails.add(userThreeEmail);
        return emails;
    }

}
