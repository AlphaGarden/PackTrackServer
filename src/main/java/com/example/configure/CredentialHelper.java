package com.example.configure;

import org.yaml.snakeyaml.Yaml;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import java.util.HashMap;
import java.util.Map;

/**
 * @author garden
 * @create 4/15/18
 */
public class CredentialHelper {
    private static CredentialHelper credentialHelper;
    private CredentialHelper(){}
    // Need to set up to be relative path.
    private static final String CREDENTIAL_CONFIG = "target/PackTrackServer-1.0-SNAPSHOT/WEB-INF/classes/Credentials.yaml";
    private static Yaml yaml;
    private static InputStream inputStream;
    private static Map<String,Object> data;

    public static CredentialHelper getCredentialHelper() {
        if (credentialHelper != null){
            return credentialHelper;
        }else{
            credentialHelper = new CredentialHelper();
            yaml = new Yaml();
            try {
                inputStream = new FileInputStream(CREDENTIAL_CONFIG);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            data = (HashMap<String, Object>)yaml.load(inputStream);
            return credentialHelper;
        }
    }


    public String getEasypostApiKey() {
        System.out.println(getClass());
        return (String) data.get("easypostApi");
    }

    public String getGmailUserName(){
        return ((Map<String,String>)data.get("google")).get("username");
    }
    public String getGmailPassWord(){
        return ((Map<String,String>)data.get("google")).get("password");
    }
    public static void main(String[] args){
       System.out.println( getCredentialHelper().getGmailPassWord());
    }


}
