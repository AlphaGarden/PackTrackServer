package com.example.model;

/**
 * @author garden
 * @create 4/29/18
 */
public class EasyMail {
    private String receiptant;
    private String subject;
    private String content;


    public EasyMail(String receiptant, String subject, String content) {
        this.receiptant = receiptant;
        this.subject = subject;
        this.content = content;
    }

    public String getReceiptant() {
        return receiptant;
    }

    public void setReceiptant(String receiptant) {
        this.receiptant = receiptant;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
