package com.seventeenkouer.web.listener;

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



    @Override
    public void contextInitialized(ServletContextEvent event) {
        //this.initWebApplicationContext(event.getServletContext());
        super.contextInitialized(event);
        //todo: 初始化药店缓存

    }
}
