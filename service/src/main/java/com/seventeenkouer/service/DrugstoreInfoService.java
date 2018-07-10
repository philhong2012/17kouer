package com.seventeenkouer.service;

import com.seventeenkouer.da.model.DrugstoreInfo;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by phil hong
 * User: wind
 * Date: 2018/6/26
 * Time: 上午10:13
 * To change this template use File | Settings | File Templates.
 */
public interface DrugstoreInfoService {
    /**
     * 获取药店
     * @param cid
     * @return
     */
    DrugstoreInfo getStoreByKey(Integer cid);

    /**
     * 根据经纬度级距离获取距离范围内药店
     * @param latitude 纬度
     * @param longitude 经度
     * @param distance 范围（公里）
     * @return 药店列表
     */
    List<DrugstoreInfo> getStoresByCoordinate(String latitude, String longitude, Long distance);

    /**
     * 获取distance范围内的药店
     * @param longitude 经度
     * @param latitude 纬度
     * @param distance 距离（米）
     * @return 药店列表
     */
    List<DrugstoreInfo> getNearByStores(BigDecimal longitude, BigDecimal latitude, Long distance);

    /**
     * 缓存所有药店信息
     */
    void cacheAllStores();

    /**
     * 保存药店
     * @param drugstoreInfo
     * @return
     */
    Integer saveStore(DrugstoreInfo drugstoreInfo);
}
