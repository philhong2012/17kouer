package com.seventeenkouer.service.impl;

import com.seventeenkouer.cache.CacheManager;
import com.seventeenkouer.common.utils.MapUtils;
import com.seventeenkouer.da.mapper.DrugstoreInfoMapper;
import com.seventeenkouer.da.model.DrugstoreInfo;
import com.seventeenkouer.service.DrugstoreInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by phil hong
 * User: wind
 * Date: 2018/6/26
 * Time: 上午10:13
 * To change this template use File | Settings | File Templates.
 */
@Service("drugstoreInfoServiceImpl")
public class DrugstoreInfoServiceImpl implements DrugstoreInfoService {
    @Autowired
    DrugstoreInfoMapper drugstoreInfoMapper;

    public DrugstoreInfo getStoreByKey(Integer cid) {
        if(cid == null) {
            return null;
        }
        return drugstoreInfoMapper.selectByPrimaryKey(cid);
    }

    public List<DrugstoreInfo> getStoresByCoordinate(String latitude, String longitude, Long distance) {
        Assert.hasText(latitude,"纬度不能为空");
        Assert.hasText(longitude,"经度不能为空");
        List<DrugstoreInfo> drugstoreInfos = new ArrayList<DrugstoreInfo>(50);
        for (Map.Entry<String,DrugstoreInfo> entry : CacheManager.getStoreInfoCache().entrySet()) {
            if(entry.getValue()!=null && entry.getValue().getPointy()!= null) {
                if (MapUtils.getDistance2(latitude, longitude,
                        entry.getValue().getPointx().toString(), entry.getValue().getPointy().toString()) < 1) {
                    drugstoreInfos.add(entry.getValue());
                }
            }
        }

        return drugstoreInfos;
    }

    public List<DrugstoreInfo> getNearByStores(BigDecimal longitude, BigDecimal latitude, Long distance) {
        Assert.notNull(latitude,"纬度不能为空");
        Assert.notNull(longitude,"经度不能为空");
        return drugstoreInfoMapper.getNearByStores(longitude,latitude,distance);
    }

    public void cacheAllStores() {
        List<DrugstoreInfo> all = drugstoreInfoMapper.selectAll();
        if(all != null) {
           for (DrugstoreInfo drugstoreInfo : all) {
                CacheManager.putStoreCache(drugstoreInfo.getCid().toString(),drugstoreInfo);
           }
        }

    }

    public Integer saveStore(DrugstoreInfo drugstoreInfo) {
        Assert.hasText(drugstoreInfo.getCname(),"药店名称不能为空");


        drugstoreInfo.setFcreatetime(new Date(System.currentTimeMillis()));
        //drugstoreInfo.set
        drugstoreInfoMapper.insertSelective(drugstoreInfo);


        DrugstoreInfo toUpdate = new DrugstoreInfo();
        toUpdate.setCid(drugstoreInfo.getCid());
        //设置药店编码,将药店编码设置成药店id，前缀"00"
        toUpdate.setDsCode("00"+drugstoreInfo.getCid());
        toUpdate.setDsCode2(drugstoreInfo.getCityCode()+toUpdate.getDsCode());
        drugstoreInfoMapper.updateByPrimaryKeySelective(toUpdate);
        return drugstoreInfo.getCid();
    }
}
