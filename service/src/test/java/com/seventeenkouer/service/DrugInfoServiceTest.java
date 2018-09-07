package com.seventeenkouer.service;

import com.serventeenkouer.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by phil hong
 * User: wind
 * Date: 2018/9/7
 * Time: 下午9:14
 * To change this template use File | Settings | File Templates.
 */
public class DrugInfoServiceTest extends BaseTest {
    @Autowired
    DrugInfoService drugInfoService;

    @Test
    public void selectByCode() {
        drugInfoService.selectByCode("081364361693");
    }
}