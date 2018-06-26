package com.seventeenkouer.web.listener;

import com.seventeenkouer.common.utils.SpringContextUtils;
import com.seventeenkouer.service.DrugstoreInfoService;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextEvent;

/**
 * Created by phil hong
 * User: wind
 * Date: 2018/6/26
 * Time: 上午10:59
 * To change this template use File | Settings | File Templates.
 */
public class WebContextLoaderListener extends ContextLoaderListener {

    DrugstoreInfoService drugstoreInfoService = SpringContextUtils.getBean("drugstoreInfoServiceImpl");

    @Override
    public void contextInitialized(ServletContextEvent event) {
        //this.initWebApplicationContext(event.getServletContext());
        super.contextInitialized(event);
        //drugstoreInfoService.cacheAllStores();

    }
}
