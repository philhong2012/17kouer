package com.seventeenkouer.service;

import com.seventeenkouer.da.model.DisplayInfo;

/**
 * Created by phil hong
 * User: wind
 * Date: 2018/6/26
 * Time: 上午10:24
 * To change this template use File | Settings | File Templates.
 */
public interface DisplayInfoService {
    /**
     * 保存药品陈列信息
     * @param displayInfo 陈列信息
     * @return >0 表示成功，否则不成功
     */
    Integer saveDisplayInfo(DisplayInfo displayInfo);
}
