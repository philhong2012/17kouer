package com.seventeenkouer.service.impl;

import com.seventeenkouer.da.mapper.DisplayInfoMapper;
import com.seventeenkouer.da.model.DisplayInfo;
import com.seventeenkouer.service.DisplayInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.Date;

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

        Assert.hasText(displayInfo.getDrugCode(),"药品编码不能为空");
        Assert.hasText(displayInfo.getDrugNumb(),"药品批次不能为空");
        Assert.hasText(displayInfo.getDispSurf(),"药品陈列面不能为空");
        Assert.hasText(displayInfo.getDispPosi(),"药品陈列位置不能为空");
        //Assert.hasText(displayInfo.getDrugPrice(),"药品价格不能为空");
        //Assert.hasText(displayInfo.getStoreNum(),"药品库存不能为空");
        Assert.isTrue(displayInfo.getDrugPrice() != null &&
        displayInfo.getDrugPrice().compareTo(BigDecimal.ZERO) >=0,"药品价格不能为空");

        Assert.isTrue(displayInfo.getStoreNum() != null &&
                displayInfo.getStoreNum().compareTo(BigDecimal.ZERO) >=0,"药品库存不能为空");

        Long currentTime = System.currentTimeMillis();

        displayInfo.setCreatetime(new Date(currentTime));
        return displayInfoMapper.insertSelective(displayInfo);
    }
}
