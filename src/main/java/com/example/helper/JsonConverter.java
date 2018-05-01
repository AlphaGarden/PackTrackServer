package com.example.helper;

import com.easypost.model.Event;
import com.easypost.model.EventDeserializer;
import com.easypost.model.Rate;
import com.easypost.model.RateDeserializer;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * @author garden
 * @create 4/30/18
 */
public class JsonConverter {
    private static JsonConverter converter;
    private JsonConverter(){}
    private static final Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .registerTypeAdapter(Event.class, new EventDeserializer())
            .registerTypeAdapter(Rate.class, new RateDeserializer())
            .create();
    public static JsonConverter getConverter(){
        if (converter != null){
            return converter;
        }else{
            converter = new JsonConverter();
            return converter;
        }
    }

    public <T> T convertFromJsonInputStrem(InputStream inputStream, Class<T> tClass){
        T t = null;
        try{
            t = gson.fromJson(new InputStreamReader(inputStream, "utf-8"), tClass);
        }catch (JsonSyntaxException e){
            System.out.println("JSON Syntax error in json file stream.");
        }catch (UnsupportedEncodingException e1){
            System.out.println("Encoding error. Invalid utf-8 encoding operation.");
        }
        return t;
    }

    public <T> T convertFromJsonString(String json, Class<T> tClass){
        T t = null;
        try{
            t = gson.fromJson(json, tClass);
        }catch (JsonSyntaxException e){
            System.out.println("JSON Syntax Error in json String.");
        }
        return t;
    }

    public <T> String convertToJsonStringWithObject(T obj){
        if (obj !=null){
            return gson.toJson(obj);
        }else{
            System.out.println("Try to converted null object into json");
            return null;
        }
    }

}
