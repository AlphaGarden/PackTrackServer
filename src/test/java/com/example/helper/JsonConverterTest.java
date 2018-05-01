package com.example.helper;

import com.easypost.model.Event;
import com.easypost.model.Tracker;
import com.example.model.ServerInfo;
import com.example.model.TrackingRecord;
import com.google.api.client.json.Json;
import io.grpc.Server;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author garden
 * @create 4/30/18
 */
public class JsonConverterTest {
    private TestHelper testHelper;
    private JsonConverter converter;
    @Before
    public void init(){
        testHelper = TestHelper.getHelper();
        converter = JsonConverter.getConverter();
    }
    @Test
    public void testConvertFromJsonString(){
        Tracker tracker = converter.convertFromJsonString(testHelper.getTrackerJsonOne(), Tracker.class);
        Event event = converter.convertFromJsonString(testHelper.getEventJson(), Event.class);
        Assert.assertNotNull(tracker);
        Assert.assertNotNull(event);

    }

    @Test
    public void testConvertToJsonFormObject(){
        Event event = converter.convertFromJsonString(testHelper.getEventJson(), Event.class);
        String json = converter.convertToJsonStringWithObject(event);
        System.out.println(json);
        Assert.assertNotNull(json);
    }

    @Test
    public void testNullObject(){
        TrackingRecord record = new TrackingRecord(
                "JDS0234912",
                "Fedex",
                "Web 23 2018xxx"
        );
        TrackingRecord record2 = new TrackingRecord(
                "bayS02312",
                "UPS",
                "Web 24 2018xx"
        );
        List<TrackingRecord> records = new LinkedList<>();
        records.add(record);
        records.add(record2);
        System.out.println(converter.convertToJsonStringWithObject(records));
    }

    @Test
    public void testServerInfo(){
        ServerInfo info = new ServerInfo("Server Exception");
        System.out.println(converter.convertToJsonStringWithObject(info));
    }
}
