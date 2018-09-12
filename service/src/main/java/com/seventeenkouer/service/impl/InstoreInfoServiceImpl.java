package com.seventeenkouer.service.impl;

import com.seventeenkouer.da.mapper.InstoreInfoMapper;
import com.seventeenkouer.da.model.InstoreInfo;
import com.seventeenkouer.service.InstoreInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Long currentTime = System.currentTimeMillis();
        instoreInfo.setInDate(new Date(currentTime));
        return instoreInfoMapper.insertSelective(instoreInfo);
    }

    public List<InstoreInfo> getTodayInstoreInfo(String loginId) {
        return instoreInfoMapper.getTodayInstoreInfo(loginId);
    }

    public List<InstoreInfo> getTodayInstoreInfoExcludeHavingNoDetails(String loginId) {
        return instoreInfoMapper.getTodayInstoreInfoExcludeHavingNoDetails(loginId);
    }

    public List<InstoreInfo> getInstoreInfoDate(String loginId, Date inDate) {
        Map<String,Object> criteria = new HashMap<String, Object>(2);
        criteria.put("loginId",loginId);
        criteria.put("inDate",inDate);
        return instoreInfoMapper.getInstoreInfoByMap(criteria);
    }
}
