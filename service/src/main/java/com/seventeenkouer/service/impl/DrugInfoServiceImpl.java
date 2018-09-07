package com.seventeenkouer.service.impl;

import com.seventeenkouer.da.mapper.DrugInfoMapper;
import com.seventeenkouer.da.model.DrugInfo;
import com.seventeenkouer.service.DrugInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by phil hong
 * User: wind
 * Date: 2018/9/7
 * Time: 上午11:05
 * To change this template use File | Settings | File Templates.
 */
@Service("DrugInfoServiceImpl")
public class DrugInfoServiceImpl implements DrugInfoService {

    @Autowired
    DrugInfoMapper drugInfoMapper;

    public DrugInfo selectByCode(String drugBcode) {
        return drugInfoMapper.selectByCode(drugBcode);
    }
}
