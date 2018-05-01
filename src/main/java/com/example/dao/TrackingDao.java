package com.example.dao;

import com.easypost.model.Tracker;
import com.example.error.FirebaseException;
import com.example.error.JacksonUtilityException;
import com.example.model.EasyTracker;
import com.example.model.PacTrackUser;

import com.example.util.JacksonUtility;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import java.util.List;

/**
 * @author garden
 * @create 4/26/18
 */
public class TrackingDao implements TrackingDaoInterface {

    String firebase_url;

    public static final String FIREBASE_API_JSON_EXTENSION = ".json";
    protected static Logger logger = Logger.getRootLogger();

    public TrackingDao(String url){
        firebase_url = url;
    }


    @Override
    public void insert(String userId, List<Tracker> trackers) throws JacksonUtilityException, FirebaseException, UnsupportedEncodingException {

        Map<String, Object> datamap = new LinkedHashMap<>();
        datamap.put(userId, trackers);

        // make the request
        String url = this.buildFullUrlFromRelativePath("Trackers");
        HttpPut request = new HttpPut( url );
        request.setEntity( this.buildEntityFromDataMap(datamap) );
        this.makeRequest( request );

    }

    @Override
    public void insert(String trackingCode, String trackerId) throws JacksonUtilityException, FirebaseException, UnsupportedEncodingException{

        Map<String, Object> datamap = new LinkedHashMap<>();
        datamap.put(trackingCode, trackerId);

        //make the request
        String url = this.buildFullUrlFromRelativePath("TrackerId");
        HttpPut request = new HttpPut(url);
        request.setEntity(this.buildEntityFromDataMap(datamap));
        this.makeRequest(request);
    }

    @Override
    public List<Tracker> getAllTrackers(String userId) throws JacksonUtilityException, FirebaseException, UnsupportedEncodingException {
        String url = this.buildFullUrlFromRelativePath(userId);
        HttpGet request = new HttpGet(url);
        return null;
    }

    @Override
    public List<PacTrackUser> getAllUsersByTrackingCode(String trackingCode) {
        return null;
    }

    @Override
    public String getTrackerIdByTrackingCode(String trackingCode) {
        return null;
    }

    @Override
    public Tracker getOneTracker(String userId, String trackingCode) {
        return null;
    }

    @Override
    public void updateTrackingInfo(String trackingCode, Tracker newTracker) {

    }

    private HttpResponse makeRequest( HttpRequestBase request ) throws FirebaseException {

        HttpResponse response = null;

        // sanity-check
        if( request == null ) {

            String msg = "request cannot be null";
            logger.error( msg );
            throw new FirebaseException( msg );
        }

        try {

            HttpClient client = new DefaultHttpClient();
            response = client.execute( request );

        } catch( Throwable t ) {

            String msg = "unable to receive response from request(" + request.getMethod() +  ") @ " + request.getURI();
            logger.error( msg );
            throw new FirebaseException( msg, t );

        }

        return response;
    }

    private StringEntity buildEntityFromDataMap( Map<String, Object> dataMap ) throws FirebaseException, JacksonUtilityException {

        String jsonData = JacksonUtility.GET_JSON_STRING_FROM_MAP( dataMap );

        return this.buildEntityFromJsonData( jsonData );
    }

    private StringEntity buildEntityFromJsonData( String jsonData ) throws FirebaseException {

        StringEntity result = null;
        try {

            result = new StringEntity( jsonData );

        } catch( Throwable t ) {

            String msg = "unable to create entity from data; data was: " + jsonData;
            logger.error( msg );
            throw new FirebaseException( msg, t );

        }

        return result;
    }

    private String buildFullUrlFromRelativePath( String path ) throws UnsupportedEncodingException {

        // massage the path (whether it's null, empty, or not) into a full URL
        if( path == null ) {
            path = "";
        }
        path = path.trim();
        if( !path.isEmpty() && !path.startsWith( "/" ) ) {
            path = "/" + path;
        }
        String url = firebase_url + path + FIREBASE_API_JSON_EXTENSION;



        if(url.lastIndexOf("&") == url.length()) {
            StringBuilder str = new StringBuilder(url);
            str.deleteCharAt(str.length());
            url = str.toString();
        }

        logger.info( "built full url to '" + url + "' using relative-path of '" + path + "'" );

        return url;
    }
}
