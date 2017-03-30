package com.seventeenkouer.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 * 系统配置文件
 */
public class ConfigUtils {

    private static Logger logger = LoggerFactory.getLogger(ConfigUtils.class);

    // 应用根目录
    private String rootPath = null;
    // classes目录
    private String classPath = null;

    private static ConfigUtils instance = new ConfigUtils();

    private ConfigUtils() {

        logger.info("OS NAME:{}", System.getProperty("os.name"));

        URL url = this.getClass().getClassLoader().getResource("/");

        if (url == null) {

            url = ConfigUtils.class.getResource("/");

        }

        classPath = url.getFile();

        if (System.getProperty("os.name") != null
                && System.getProperty("os.name").toUpperCase().indexOf("WINDOWS") != -1
                && classPath.startsWith("/")) {

            classPath = classPath.substring(1);

        }

        classPath = classPath.replace("%20", " ");

        rootPath = classPath.replace("/WEB-INF/classes/", "");

        rootPath = rootPath.replace("%20", " ");

        logger.info("classPath:" + classPath);

        logger.info("rootPath:" + rootPath);

    }

    /**
     * 取唯一的cfg实例
     *
     * @return 唯一的cfg实例
     */
    public static synchronized ConfigUtils getInstance() {
        return instance;
    }

    /**
     * 工具方法,读取Properties配置文件
     *
     * @param propPath properties配置文件绝对路径
     * @return Properties
     */
    public static Properties loadProperties(String propPath) {
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File(propPath));
            properties.load(inputStream);
        } catch (IOException e) {
            logger.error("load properties error." + propPath, e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                    logger.warn("load properties error:" + e.getMessage());
                }
            }
        }
        return properties;
    }

    /**
     * 获取应用根目录（网站根目录,如d:\MyApp）
     *
     * @return
     */
    public String getRoot() {
        return rootPath;
    }


    /**
     * 取WEB-INF绝对路径
     *
     * @return WEB-INF绝对路径目录(eg:/X:/XXX//WEB-INF/)
     */
    public String getWebInf() {
        if (classPath.indexOf("WEB-INF") != -1) {
            return getRoot() + "/WEB-INF/";
        } else {
            logger.warn("no WEB-INF path in current environment. return the root path instead.");
            return getRoot();
        }
    }

    /**
     * 取类的运行根目录的绝对路径
     *
     * @return classes绝对路径目录(eg:在web环境中返回/X:/XXX//WEB-INF/classes/)
     */
    public String getClassPath() {
        return classPath;
    }


    public static void main(String[] args) {
        System.out.println(ConfigUtils.getInstance().getRoot());
        System.out.println(ConfigUtils.getInstance().getWebInf());
    }

}
