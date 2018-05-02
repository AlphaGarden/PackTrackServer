package com.example.helper;


import com.example.configure.SysConfigHelper;
import com.example.model.EasyMail;

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
public class MailHelper {
    private static final SysConfigHelper credentialHelper = SysConfigHelper.getCredentialHelper();
    private static MailHelper mailHelper;
    private static String USER_NAME = credentialHelper.getGmailUserName();
    private static String PASS_WORD = credentialHelper.getGmailPassWord();
    private static String SMTP_HOST = credentialHelper.getSmtpHost();
    private static String SMTP_PORT = credentialHelper.getSmtpPort();
    private static Properties properties = System.getProperties();
    private MailHelper(){}

    public static MailHelper getInstance(){
        if (mailHelper != null){
            return mailHelper;
        }else {
            mailHelper = new MailHelper();
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.host", SMTP_HOST);
            properties.put("mail.smtp.port", SMTP_PORT);
            properties.put("mail.smtp.user", USER_NAME);
            properties.put("mail.smtp.password", PASS_WORD);
            properties.put("mail.smtp.auth","true");
            return mailHelper;
        }
    }

    private class SendThread implements Runnable{
        EasyMail mail;
        public SendThread(EasyMail newMail){
            this.mail = newMail;
        }
        @Override
        public void run() {
            send(this.mail);
        }
    }

    public SendThread createSendThread(EasyMail mail){
        return new SendThread(mail);
    }

    private void send(EasyMail mail){
        Session session = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(USER_NAME));
            InternetAddress toAddress = new InternetAddress(mail.getReceiptant());
            message.addRecipient(Message.RecipientType.TO, toAddress);
            message.setSubject(mail.getSubject());
            message.setContent(mail.getContent(),"text/html; charset=utf-8");
            message.saveChanges();
            Transport transport = session.getTransport("smtp");
            transport.connect(SMTP_HOST, USER_NAME, PASS_WORD);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            System.out.println("The test email has been sent!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }


    }
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
            InternetAddress toAddress = new InternetAddress("313016129@qq.com");
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
