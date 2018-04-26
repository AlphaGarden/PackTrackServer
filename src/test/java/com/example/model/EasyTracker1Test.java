package com.example.model;

import org.junit.Before;
import org.junit.Test;

/**
 * @author garden
 * @create 4/17/18
 */
public class EasyTracker1Test {
    private TrackerSample easyTracker;

    @Before
    public void init(){
        this.easyTracker = new TrackerSample();
    }

    @Test
    public void testCreateTracker(){
        this.easyTracker.createTracker();
    }

    @Test
    public void testListAllTracker(){

    }

    @Test
    public void testListAllWebhooks(){
        this.easyTracker.listWebhookCollectionUrl();
    }

    @Test
    public void testDeleteAllWebhook(){
        this.easyTracker.deleteAllWebhook();
    }


    @Test
    public void tesCreateWebhook(){
        String url = "https://20180418t102151-dot-packtrack-200423.appspot.com";
        this.easyTracker.createWebhookWithUrl(url);
    }
}
