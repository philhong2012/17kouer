package com.seventeenkouer.service;

import com.seventeenkouer.da.model.SysUser;
import org.apache.ibatis.annotations.Param;

/**
 * Created by phil hong
 * User: wind
 * Date: 2018/6/25
 * Time: 下午11:02
 * To change this template use File | Settings | File Templates.
 */
public interface SysUserService {
    /**
     * 验证用户名密码
     * @param account 用户账号
     * @param password 用户密码
     * @return true：用户名密码正确；false：用户名或密码错误
     */
    boolean validateUser(String account,String password);

    /**
     * 获取用户
     * @param account
     * @param password
     * @return
     */
    SysUser selectByAccountAndPsw(String account, String password);
}
