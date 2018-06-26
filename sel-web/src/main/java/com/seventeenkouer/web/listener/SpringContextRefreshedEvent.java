package com.seventeenkouer.web.listener;

import com.seventeenkouer.service.DrugstoreInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * Created by phil hong
 * User: wind
 * Date: 2018/6/26
 * Time: 下午2:18
 * To change this template use File | Settings | File Templates.
 */
public class SpringContextRefreshedEvent implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    DrugstoreInfoService dss;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        dss.cacheAllStores();
    }
}
