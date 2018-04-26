package com.example.model;

/**
 * @author garden
 * @create 4/16/18
 */
public class CloudMessage {
    private String toClient; // The Client ID
    private String message; // The message body

    private CloudMessage(CloudMessageBuilder builder){
        this.toClient = builder.toClient;
        this.message = builder.message;
    }

    public static CloudMessageBuilder builder(){
        return new CloudMessageBuilder();
    }

    public static class CloudMessageBuilder{
        private String toClient; // The Client ID
        private String message; // The message body

        public CloudMessageBuilder withToClient(String toClient){
            this.toClient = toClient;
            return this;
        }

        public CloudMessageBuilder withMessage(String messgae){
            this.message = messgae;
            return this;
        }

        public CloudMessage build(){
            return new CloudMessage(this);
        }
    }

    public String getToClient() {
        return toClient;
    }

    public void setToClient(String toClient) {
        this.toClient = toClient;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
