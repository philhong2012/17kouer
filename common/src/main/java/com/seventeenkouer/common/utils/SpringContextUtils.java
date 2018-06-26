package com.seventeenkouer.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by phil hong
 * User: wind
 * Date: 2018/6/26
 * Time: 下午12:23
 * To change this template use File | Settings | File Templates.
 */

    public class SpringContextUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        applicationContext = context;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 根据bean名称获取Bean
     *
     * @param <T>
     * @param name Spring中定义的BeanID
     * @return BeanID对应的实例化对象（Spring定义的Service)
     * @throws BeansException
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) throws BeansException {
        if (applicationContext == null) {
            return null;
        }
        return (T) applicationContext.getBean(name);
    }

    /**
     * 根据class类名获取Bean
     *
     * @param <T>
     * @param className
     * @return
     */
    public static <T> T getBean(Class<T> className) {
        if (applicationContext == null) {
            return null;
        }
        return applicationContext.getBean(className);
    }

    public static void unRegisterBean(String beanName) {
        ConfigurableApplicationContext context = (ConfigurableApplicationContext) applicationContext;
        DefaultListableBeanFactory beanfactory = (DefaultListableBeanFactory) context.getBeanFactory();
        beanfactory.removeBeanDefinition(beanName);
    }
}

