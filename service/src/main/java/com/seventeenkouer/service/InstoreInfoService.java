package com.seventeenkouer.service;

import com.seventeenkouer.da.model.InstoreInfo;

/**
 * Created by phil hong
 * User: wind
 * Date: 2018/6/26
 * Time: 上午10:19
 * To change this template use File | Settings | File Templates.
 */
public interface InstoreInfoService {
    /**
     * 保存巡视药店信息
     * @param instoreInfo 药店信息
     * @return >0 表示成功，否则不成功
     */
    Integer saveInstoreInfo(InstoreInfo instoreInfo);

}
