package com.seventeenkouer.service;

import com.seventeenkouer.da.model.DrugInfo;
import org.apache.ibatis.annotations.Param;

/**
 * Created by phil hong
 * User: wind
 * Date: 2018/9/7
 * Time: 上午11:04
 * To change this template use File | Settings | File Templates.
 */
public interface DrugInfoService {
    /**
     * 根据条码获取药品信息
     * @param drugBcode 药品条码
     * @return
     */
    DrugInfo selectByCode(String drugBcode);
}
