package com.example.helper;

import com.example.model.EasyMail;
import org.junit.Before;
import org.junit.Test;

/**
 * @author garden
 * @create 4/29/18
 */
public class MailHelperTest {
    private MailHelper mailHelper;
    @Before
    public void init(){
        mailHelper = MailHelper.getInstance();
    }

    @Test
    public void testSend(){
        // TODO Fixed Bug Unable to send message out.
        EasyMail easyMail = new EasyMail("313016129@qq.com","Test from update", "<h1>Hello world</h1>");
        mailHelper.send(easyMail);
    }
}
