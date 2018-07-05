package com.seventeenkouer.service.impl;

import com.seventeenkouer.da.mapper.DisplayInfoMapper;
import com.seventeenkouer.da.model.DisplayInfo;
import com.seventeenkouer.service.DisplayInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * Created by phil hong
 * User: wind
 * Date: 2018/6/26
 * Time: 上午10:26
 * To change this template use File | Settings | File Templates.
 */
@Service("displayInfoServiceImpl")
public class DisplayInfoServiceImpl implements DisplayInfoService {
    @Autowired
    DisplayInfoMapper displayInfoMapper;

    public Integer saveDisplayInfo(DisplayInfo displayInfo) {
        Assert.hasText(displayInfo.getDrugBcode(),"药品条码不能为空");
        Assert.hasText(displayInfo.getDrugName(),"药品名称不能为空");
        return displayInfoMapper.insertSelective(displayInfo);
    }
}
