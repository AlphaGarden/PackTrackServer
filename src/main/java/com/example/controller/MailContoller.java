package com.example.controller;


import com.example.configure.CredentialHelper;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @author garden
 * @create 4/16/18
 */
public class MailContoller {
    private static String USER_NAME = CredentialHelper.getCredentialHelper().getGmailUserName();
    private static String PASS_WORD = CredentialHelper.getCredentialHelper().getGmailPassWord();
    private static String RECEIPTANT = "guolei1717@gmail.com";
    private static String SMTP_HOST = "smtp.gmail.com";
    private static String SMTP_PORT = "587";
    public static void main(String[] args){
        String subject = "Test From the JAVA MAIL";
        String content = "<div style=\"color:red;\">Hello Noble Library.</div>";
        Properties properties = System.getProperties();
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", SMTP_HOST);
        properties.put("mail.smtp.port", SMTP_PORT);
        properties.put("mail.smtp.user", USER_NAME);
        properties.put("mail.smtp.password", PASS_WORD);
        properties.put("mail.smtp.auth","true");


        Session session = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(USER_NAME));
            InternetAddress toAddress = new InternetAddress(RECEIPTANT);
            message.addRecipient(Message.RecipientType.TO, toAddress);
            message.setSubject(subject);
            message.setContent(content,"text/html; charset=utf-8");
            message.saveChanges();
            Transport transport = session.getTransport("smtp");
            System.out.println("Try to connect the host!");
            transport.connect(SMTP_HOST, USER_NAME, PASS_WORD);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            System.out.println("The test email has been sent!");
            System.out.println("Add some difference!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
