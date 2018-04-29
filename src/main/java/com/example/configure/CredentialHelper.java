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
    private static Map<String, String> gmailConfig;
    private static Map<String, String> smtpConfig;

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
            gmailConfig = (Map<String,String>)data.get("google");
            smtpConfig = (Map<String,String>)data.get("smtp");
            return credentialHelper;
        }
    }


    public String getEasypostApiKey() {

        return (String) data.get("easypostApi");
    }

    public String getGmailUserName(){
        System.out.println(gmailConfig.get("username"));
        return gmailConfig.get("username");
    }
    public String getGmailPassWord(){
        System.out.println(gmailConfig.get("password"));
        return gmailConfig.get("password");
    }
    public String getSmtpHost(){
        return smtpConfig.get("host");
    }
    public String getSmtpPort(){
        return smtpConfig.get("port");
    }
    public static void main(String[] args){
       System.out.println( getCredentialHelper().getGmailPassWord());
    }


}
