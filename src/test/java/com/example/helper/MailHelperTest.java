package com.example.helper;

import com.example.model.EasyMail;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author garden
 * @create 4/29/18
 */
public class MailHelperTest {
    private MailHelper mailHelper;
    ExecutorService executorService;
    @Before
    public void init(){
        mailHelper = MailHelper.getInstance();
    }

    @Test
    public void testSend(){
        // Ensure the operation is enabled in gmail.
        List<String> emailList = new LinkedList<>();
        emailList.add("1419286710@qq.com");
        emailList.add("313016129@qq.com");
        String content ="";

        executorService = Executors.newFixedThreadPool(10);
        for(int i = 0; i <1; i++ ){
            EasyMail easyMail = new EasyMail("unknown","送你一瓶柠檬茶", "","","","","");
            String receiptant = emailList.get(i%emailList.size());
            System.out.println("Send notification email to "+receiptant);
            easyMail.setReceiptant(receiptant);

            // Create a new thread and run
            executorService.execute(mailHelper.createSendThread(easyMail));
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(2000, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
