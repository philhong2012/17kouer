package com.seventeenkouer.service;

import com.seventeenkouer.da.model.InstoreInfo;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

    /**
     * 获取当天的巡店记录
     * @param loginId 账号Id
     * @return 巡店记录
     */
    List<InstoreInfo> getTodayInstoreInfo(String loginId);



    /**
     * 获取当天的巡店记录,过滤掉不包含巡店详情掉数据
     * @param loginId 账号Id
     * @return 巡店记录
     */
    List<InstoreInfo> getTodayInstoreInfoExcludeHavingNoDetails(String loginId);

    /**
     *
     * @param loginId 账号Id
     * @param inDate 进店日期
     * @return 巡店记录
     */
    List<InstoreInfo> getInstoreInfoDate(String loginId, Date inDate);

}
