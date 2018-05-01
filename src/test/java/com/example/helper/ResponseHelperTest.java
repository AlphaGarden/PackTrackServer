package com.example.helper;

import org.junit.Before;
import org.junit.Test;

/**
 * @author garden
 * @create 4/30/18
 */
public class ResponseHelperTest {
    private ResponseHelper responseHelper;
    @Before
    private void init(){
        responseHelper = ResponseHelper.getResponseHelper();
    }
}
