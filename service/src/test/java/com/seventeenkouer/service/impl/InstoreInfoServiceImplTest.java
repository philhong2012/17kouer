package com.seventeenkouer.service.impl;

import com.serventeenkouer.test.BaseTest;
import com.seventeenkouer.da.model.InstoreInfo;
import com.seventeenkouer.service.InstoreInfoService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by phil hong
 * User: wind
 * Date: 2018/7/22
 * Time: 上午11:39
 * To change this template use File | Settings | File Templates.
 */
public class InstoreInfoServiceImplTest extends BaseTest {

    @Autowired
    InstoreInfoService instoreInfoService;

    @Test
    public void getTodayInstoreInfo() {
        String loginId = "1004";
        List<InstoreInfo> instoreInfoList = instoreInfoService.getTodayInstoreInfo(loginId);
        Assert.isTrue(instoreInfoList.size() > 0);
    }

    @Test
    public void getInstoreInfoDate() {
        String loginId = "1004";
        Date date = new Date(System.currentTimeMillis());

        List<InstoreInfo> instoreInfoList = instoreInfoService.getInstoreInfoDate(loginId,date);
        Assert.isTrue(instoreInfoList.size() > 0);
    }
}