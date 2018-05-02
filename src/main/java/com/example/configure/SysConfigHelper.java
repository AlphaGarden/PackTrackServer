package com.example.configure;

import org.yaml.snakeyaml.Yaml;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import java.util.HashMap;
import java.util.Map;

/**
 * @author garden
 * @create 4/15/18
 */
public class SysConfigHelper {
//    private static SysConfigHelper credentialHelper;
//    private SysConfigHelper(){}
//    // Need to set up to be relative path.
//    private static final String CREDENTIAL_CONFIG = "WEB-INF/SysConfig.yaml";
//    private static Yaml yaml;
//    private static InputStream inputStream;
//    private static Map<String,Object> data;
//    private static Map<String, String> gmailConfig;
//    private static Map<String, String> smtpConfig;
//
//    public static SysConfigHelper getCredentialHelper() {
//        if (credentialHelper != null){
//            return credentialHelper;
//        }else{
//            credentialHelper = new SysConfigHelper();
//            yaml = new Yaml();
//            try {
//                inputStream = new FileInputStream(CREDENTIAL_CONFIG);
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//            data = (HashMap<String, Object>)yaml.load(inputStream);
//            gmailConfig = (Map<String,String>)data.get("google");
//            smtpConfig = (Map<String,String>)data.get("smtp");
//            return credentialHelper;
//        }
//    }



//    public String getEasypostApiKey() {
//
//        return "T5DOCT0xW4NHVB35ZIqBPg";
//    }
//
//    public String getGmailUserName(){
//        System.out.println(gmailConfig.get("username"));
//        return ;
//    }
//    public String getGmailPassWord(){
//        System.out.println(gmailConfig.get("password"));
//        return gmailConfig.get("password");
//    }
//    public String getSmtpHost(){
//        return smtpConfig.get("host");
//    }
//    public String getSmtpPort(){
//        return smtpConfig.get("port");
//    }
//    public int getThreadPoolSize(){
//        return  (int)data.get("threadPoolSize");
//    }
//
    private static SysConfigHelper credentialHelper;
    private SysConfigHelper(){}
    public static SysConfigHelper getCredentialHelper() {
        if (credentialHelper != null) {
            return credentialHelper;
        } else {
            credentialHelper = new SysConfigHelper();
            return credentialHelper;
        }
    }
    public String getEasypostApiKey(){

    return "T5DOCT0xW4NHVB35ZIqBPg";
}

    public String getGmailUserName(){

        return "pactrackservice@gmail.com";
    }
    public String getGmailPassWord(){
        return "cse546project2";
    }
    public String getSmtpHost(){
        return "smtp.gmail.com";
    }
    public String getSmtpPort(){
        return "587";
    }
    public int getThreadPoolSize(){
        return  10;
    }

    public String getRealtimeUrl(){ return "https://playchat-fe621.firebaseio.com/";}



}
