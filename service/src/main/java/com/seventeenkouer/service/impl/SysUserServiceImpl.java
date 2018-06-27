package com.seventeenkouer.service.impl;

import com.seventeenkouer.common.utils.StringUtils;
import com.seventeenkouer.da.mapper.SysUserMapper;
import com.seventeenkouer.da.model.SysUser;
import com.seventeenkouer.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by phil hong
 * User: wind
 * Date: 2018/6/25
 * Time: 下午11:06
 * To change this template use File | Settings | File Templates.
 */
@Service("sysUserServiceImpl")
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    SysUserMapper sysUserMapper;
    public boolean validateUser(String account, String password) {
        if(StringUtils.isEmpty(account) || StringUtils.isEmpty(password)) {
            return false;
        }
        return sysUserMapper.validateUser(account,password) > 0;
    }

    public SysUser selectByAccountAndPsw(String account, String password) {
        if(StringUtils.isEmpty(account) || StringUtils.isEmpty(password)) {
            return null;
        }
        return sysUserMapper.selectByAccountAndPsw(account,password);
    }
}
