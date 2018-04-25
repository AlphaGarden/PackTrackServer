package com.example.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author garden
 * @create 4/23/18
 */
public class EasyTrackerTest {
    private EasyTracker tracker;
    private EasyTracker tracker2;
    private String trackerId;
    private String trackingCode;
    private String upToDateStatus;
    private String estDeliveryDate;
    private String updateAt;
    private String carrier;
    private List<EasyTrackingDetail> easyTrackingDetails;

    @Before
    public void init(){
        this.trackerId = "trk_9d408ea9fce64e8e9cbfce35d2d69b55";
        this.trackingCode = "EZ5000000005";
        this.upToDateStatus = "return_to_sender";
        this.estDeliveryDate = "2018-04-18T19:18:32Z";
        this.updateAt = "2018-04-18T19:18:32Z";
        this.carrier = "FedEx";


    }

    @Test
    public void testBuild(){
        this.tracker =EasyTracker.builder().withTrackerId(this.trackerId).build();
        Assert.assertNotNull(this.tracker);
        System.out.println(this.tracker.getTrackerId());
        this.tracker2 = (new EasyTracker.EasyTrackerBuilder()).withTrackerId("Hello world").build();
        System.out.println(this.tracker2.getTrackerId());
    }


    @Test
    public void testTrackerId(){


    }
}
