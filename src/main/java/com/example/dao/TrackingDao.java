package com.example.dao;

import com.easypost.model.*;
import com.example.error.FirebaseException;
import com.example.error.JacksonUtilityException;
import com.example.helper.JsonConverter;
import com.example.model.FirebaseResponse;
import com.example.util.JacksonUtility;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.*;

/**
 * @author garden
 * @create 4/26/18
 */
public class TrackingDao implements TrackingDaoInterface {

    String firebase_url = "https://playchat-fe621.firebaseio.com/";

    public static final String FIREBASE_API_JSON_EXTENSION = ".json";
    protected static Logger logger = Logger.getRootLogger();

    public TrackingDao(){
    }

    @Override
    public void insert(String userId, String trackerId) throws JacksonUtilityException, FirebaseException, UnsupportedEncodingException{

        //build user_code
        String user_code = this.longHash(userId);
        String url_code = this.buildFullUrlFromRelativePath("UserCode/" + user_code);
        Map<String, Object> datamap_userCode = new LinkedHashMap<>();
        datamap_userCode.put("e-mail", userId);
        HttpPut request_code = new HttpPut(url_code);
        request_code.setEntity(this.buildEntityFromDataMap(datamap_userCode));
        this.makeRequest(request_code);

        Map<String, Object> datamap = new LinkedHashMap<>();
        String key = "trackerId";
        datamap.put(key, trackerId);

        // make the request
        String url = this.buildFullUrlFromRelativePath("User/" + user_code + "/" + trackerId);
        HttpPut request = new HttpPut( url );
        request.setEntity( this.buildEntityFromDataMap(datamap) );
        this.makeRequest( request );

        Map<String, Object> datamap2 = new LinkedHashMap<>();
        String key2 = "userId";
        datamap2.put(key2, userId);

        // make the request
        String url2 = this.buildFullUrlFromRelativePath("TrackerId/" + trackerId + "/" + user_code);
        HttpPut request2 = new HttpPut(url2);
        request2.setEntity(this.buildEntityFromDataMap(datamap2));
        this.makeRequest(request2);
    }

    @Override
    public void insert(String trackingCode, String carrier, String trackerId) throws JacksonUtilityException, FirebaseException, UnsupportedEncodingException{

        Map<String, Object> datamap = new LinkedHashMap<>();
        String key = "trackerId";
        datamap.put(key, trackerId);

        // make the request
        String url = this.buildFullUrlFromRelativePath("TrackingCodeToTrackerId/" + trackingCode + "-" + carrier);
        HttpPut request = new HttpPut( url );
        request.setEntity( this.buildEntityFromDataMap(datamap) );
        this.makeRequest( request );
    }

    @Override
    public void insert(String trackingId, Tracker tracker) throws JacksonUtilityException, FirebaseException, UnsupportedEncodingException{

        Map<String, Object> datamap = new LinkedHashMap<>();
        String key = "tracker_information";
        JsonConverter converter = JsonConverter.getConverter();
        datamap.put(key, converter.convertToJsonStringWithObject(tracker));
        // make the request
        String url = this.buildFullUrlFromRelativePath("Trackers/" + trackingId);
        HttpPut request = new HttpPut( url );
        request.setEntity( this.buildEntityFromDataMap(datamap) );
        this.makeRequest( request );
    }

    @Override
    public void deleteTrackerById(String userId, String trackerId) throws FirebaseException, UnsupportedEncodingException{

        String user_code = this.longHash(userId);

        String url = this.buildFullUrlFromRelativePath("User/" + user_code + "/" + trackerId);
        HttpDelete request = new HttpDelete(url);
        this.makeRequest(request);

        String url2 = this.buildFullUrlFromRelativePath("TrackerId/" + trackerId + "/" + user_code);
        HttpDelete request2 = new HttpDelete(url2);
        this.makeRequest(request2);
    }

    @Override
    public void updateTrackerByTrackerId(String trackerId, Tracker newTracker) throws JacksonUtilityException, FirebaseException, UnsupportedEncodingException{

        Map<String, Object> datamap = new LinkedHashMap<>();
        String key = "tracker_information";
        JsonConverter converter = JsonConverter.getConverter();
        datamap.put(key, converter.convertToJsonStringWithObject(newTracker));

        // make the request
        String url = this.buildFullUrlFromRelativePath("Trackers/" + trackerId);
        HttpPatch request = new HttpPatch(url);
        request.setEntity(this.buildEntityFromDataMap(datamap));
        this.makeRequest(request);
    }

    @Override
    public List<Tracker> getAllTrackers(String userId) throws JacksonUtilityException, FirebaseException, UnsupportedEncodingException{

        String user_code = this.longHash(userId);

        List<Tracker> list = new ArrayList<>();
        //make the request
        String url = this.buildFullUrlFromRelativePath("User");
        HttpGet request = new HttpGet(url);
        HttpResponse httpResponse = this.makeRequest(request);

        //process the response
        FirebaseResponse response = this.processResponse(FirebaseRestMethod.GET, httpResponse);

        // get the map from json
        Map<String, Object> datamap = response.getBody();
        Map<String, Object> tracking_codes = (Map<String, Object>) datamap.get(user_code);
        Set<String> string_codes = tracking_codes.keySet();
        String[] s = string_codes.toArray(new String[string_codes.size()]);

        for(int i = 0; i < string_codes.size(); i++){
//            String url_tracker = this.buildFullUrlFromRelativePath("Trackers/" + s[i]);
//            HttpGet request2 = new HttpGet(url_tracker);
//            HttpResponse httpResponse2 = this.makeRequest(request2);
//
//            FirebaseResponse response2 = this.processResponse(FirebaseRestMethod.GET, httpResponse2);
//            Map<String, Object> datamap2 = response2.getBody();
//            JsonConverter converter = JsonConverter.getConverter();
//            //tracker = converter.convertFromJsonString(datamap2.get("tracker_information:"), Tracker.class);
//            list.add(converter.convertFromJsonString(converter.convertToJsonStringWithObject(datamap2.get("tracker_information")), Tracker.class));
            Tracker tracker = getOneTracker(s[i]);
            list.add(tracker);
        }
        return list;
    }

    @Override
    public List<String> getAllUserIdsByTrackerId(String trackerId) throws JacksonUtilityException, FirebaseException, UnsupportedEncodingException{

        String url = this.buildFullUrlFromRelativePath("TrackerId/" + trackerId);
        HttpGet request = new HttpGet(url);
        HttpResponse httpResponse = this.makeRequest(request);

        //process the response
        FirebaseResponse response = this.processResponse(FirebaseRestMethod.GET, httpResponse);
        Map<String, Object> datamap = response.getBody();
        Set<String> string_user = datamap.keySet();
        List<String> list = new ArrayList<>(string_user.size());
        String[] array = string_user.toArray(new String[string_user.size()]);
        for(String s: array){
            String url2 = this.buildFullUrlFromRelativePath("UserCode/" + s);
            HttpGet r = new HttpGet(url2);
            HttpResponse hr = this.makeRequest(r);

            FirebaseResponse response2 = this.processResponse(FirebaseRestMethod.GET, hr);
            Map<String, Object> map = response2.getBody();
            list.add(map.get("e-mail").toString());
        }

        return list;
    }

    @Override
    public List<String> getEmailsByTrackerId(String trackerId) throws JacksonUtilityException, FirebaseException, UnsupportedEncodingException{
        String url = this.buildFullUrlFromRelativePath("TrackerId/" + trackerId);
        HttpGet request = new HttpGet(url);
        HttpResponse httpResponse = this.makeRequest(request);

        //process the response
        FirebaseResponse response = this.processResponse(FirebaseRestMethod.GET, httpResponse);
        Map<String, Object> datamap = response.getBody();
        if(datamap == null) return  null;
        Set<String> string_user = datamap.keySet();
        List<String> list = new ArrayList<>(string_user.size());
        String[] array = string_user.toArray(new String[string_user.size()]);
        for(String s: array){
            String url2 = this.buildFullUrlFromRelativePath("UserCode/" + s);
            HttpGet r = new HttpGet(url2);
            HttpResponse hr = this.makeRequest(r);

            FirebaseResponse response2 = this.processResponse(FirebaseRestMethod.GET, hr);
            Map<String, Object> map = response2.getBody();
            list.add(map.get("e-mail").toString());
            //list.add(s);
        }

        return list;
    }

    @Override
    public String getTrackerIdByTrackingCodeAndCarrier(String trackingCode, String carrier) throws JacksonUtilityException, FirebaseException, UnsupportedEncodingException{

        String url = this.buildFullUrlFromRelativePath("TrackingCodeToTrackerId/" + trackingCode + "-" + carrier);
        HttpGet request = new HttpGet(url);
        HttpResponse httpResponse = this.makeRequest(request);

        //process the response
        FirebaseResponse response = this.processResponse(FirebaseRestMethod.GET, httpResponse);
        Map<String, Object> datamap = response.getBody();

        Object result = datamap.get("trackerId");
        return result == null ? null : result.toString();
    }

    @Override
    public Tracker getOneTracker(String trackingId) throws JacksonUtilityException, FirebaseException, UnsupportedEncodingException{

        String url = this.buildFullUrlFromRelativePath("Trackers/" + trackingId);
        HttpGet request = new HttpGet(url);
        HttpResponse httpResponse = this.makeRequest(request);

        //process the response
        FirebaseResponse response = this.processResponse(FirebaseRestMethod.GET, httpResponse);
        Map<String, Object> datamap = response.getBody();
        JsonConverter converter = JsonConverter.getConverter();
        Tracker tracker =  converter.convertFromJsonString((String)datamap.get("tracker_information"), Tracker.class);
        return tracker;
    }


    private HttpResponse makeRequest(HttpRequestBase request ) throws FirebaseException {

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

    private FirebaseResponse processResponse(FirebaseRestMethod method, HttpResponse httpResponse ) throws FirebaseException {

        FirebaseResponse response = null;

        // sanity-checks
        if( method == null ) {

            String msg = "method cannot be null";
            logger.error( msg );
            throw new FirebaseException( msg );
        }
        if( httpResponse == null ) {

            String msg = "httpResponse cannot be null";
            logger.error( msg );
            throw new FirebaseException( msg );
        }

        // get the response-entity
        HttpEntity entity = httpResponse.getEntity();

        // get the response-code
        int code = httpResponse.getStatusLine().getStatusCode();

        // set the response-success
        boolean success = false;
        switch( method ) {
            case DELETE:
                if( httpResponse.getStatusLine().getStatusCode() == 204
                        && "No Content".equalsIgnoreCase( httpResponse.getStatusLine().getReasonPhrase() ) )
                {
                    success = true;
                }
                break;
            case PATCH:
            case PUT:
            case POST:
            case GET:
                if( httpResponse.getStatusLine().getStatusCode() == 200
                        && "OK".equalsIgnoreCase( httpResponse.getStatusLine().getReasonPhrase() ) )
                {
                    success = true;
                }
                break;
            default:
                break;

        }

        // get the response-body
        Writer writer = new StringWriter();
        if( entity != null ) {

            try {

                InputStream is = entity.getContent();
                char[] buffer = new char[1024];
                Reader reader = new BufferedReader( new InputStreamReader( is, "UTF-8" ) );
                int n;
                while( (n=reader.read(buffer)) != -1 ) {
                    writer.write( buffer, 0, n );
                }

            } catch( Throwable t ) {

                String msg = "unable to read response-content; read up to this point: '" + writer.toString() + "'";
                writer = new StringWriter(); // don't want to later give jackson partial JSON it might choke on
                logger.error( msg );
                throw new FirebaseException( msg, t );

            }
        }

        // convert response-body to map
        Map<String, Object> body = null;
        try {

            body = JacksonUtility.GET_JSON_STRING_AS_MAP( writer.toString() );

        } catch( JacksonUtilityException jue ) {

            String msg = "unable to convert response-body into map; response-body was: '" + writer.toString() + "'";
            logger.error( msg );
            throw new FirebaseException( msg, jue );
        }

        // build the response
        response = new FirebaseResponse( success, code, body, writer.toString() );


        return response;
    }

    public enum FirebaseRestMethod {

        GET,
        PATCH,
        PUT,
        POST,
        DELETE;
    }

    public String longHash(String string) {
        long h = 98764321261L;
        int l = string.length();
        char[] chars = string.toCharArray();

        for (int i = 0; i < l; i++) {
          h = 31*h + chars[i];
        }
        return Long.toString(h);
      }
}
