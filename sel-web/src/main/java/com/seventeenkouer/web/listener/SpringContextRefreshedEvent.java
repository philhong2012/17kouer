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
        /**
         * 目前有7万多家药店，当云主机的带宽只有1M的时候，如果应用与数据库不部署在同一机器，查询数据库要耗时2分钟左右
         * 是否可以启动多个线程，每个线程负责取特定页的数据，切割7万条数据分成20份，每份3500+，异步缓存？
         */
        //dss.cacheAllStores();
    }
}
