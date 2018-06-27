package com.seventeenkouer.service.impl;

import com.seventeenkouer.da.mapper.InstoreInfoMapper;
import com.seventeenkouer.da.model.InstoreInfo;
import com.seventeenkouer.service.InstoreInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by phil hong
 * User: wind
 * Date: 2018/6/26
 * Time: 上午10:26
 * To change this template use File | Settings | File Templates.
 */
@Service("instoreInfoServiceImpl")
public class InstoreInfoServiceImpl implements InstoreInfoService {
    @Autowired
    InstoreInfoMapper instoreInfoMapper;
    public Integer saveInstoreInfo(InstoreInfo instoreInfo) {
        return instoreInfoMapper.insertSelective(instoreInfo);
    }
}
