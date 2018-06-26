package com.seventeenkouer.service.impl;

import com.seventeenkouer.da.mapper.DisplayInfoMapper;
import com.seventeenkouer.da.model.DisplayInfo;
import com.seventeenkouer.service.DisplayInfoService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by phil hong
 * User: wind
 * Date: 2018/6/26
 * Time: 上午10:26
 * To change this template use File | Settings | File Templates.
 */
public class DisplayInfoServiceImpl implements DisplayInfoService {
    @Autowired
    DisplayInfoMapper displayInfoMapper;

    public Integer saveDisplayInfo(DisplayInfo displayInfo) {
        return displayInfoMapper.insertSelective(displayInfo);
    }
}
