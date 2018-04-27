package com.example.dao;

import org.junit.Before;
import org.junit.Test;

/**
 * @author garden
 * @create 4/27/18
 */
public class EasyPostDaoTest {
    private EasyPostDao easyPostDao;

    @Before
    public void init(){
        easyPostDao = EasyPostDao.getEasyPostDao();
    }

}
