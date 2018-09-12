package com.seventeenkouer.service.impl;

import com.serventeenkouer.test.BaseTest;
import com.seventeenkouer.da.model.DrugstoreInfo;
import com.seventeenkouer.service.DrugstoreInfoService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import java.util.Date;

/**
 * Created by phil hong
 * User: wind
 * Date: 2018/7/5
 * Time: 下午9:49
 * To change this template use File | Settings | File Templates.
 */
public class DrugstoreInfoServiceImplTest extends BaseTest {

    @Autowired
    DrugstoreInfoService drugstoreInfoService;

    @Test
    @Rollback(false)
    public void saveStore() {
        DrugstoreInfo drugstoreInfo = new DrugstoreInfo();
        drugstoreInfo.setCname("test");
        drugstoreInfo.setDsCode("test");
        drugstoreInfo.setAreaCode("test");
        drugstoreInfo.setFcreatetime(new Date(System.currentTimeMillis()));
        drugstoreInfo.setSales("test");
        drugstoreInfoService.saveStore(drugstoreInfo);

    }
}