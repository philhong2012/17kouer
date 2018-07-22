package com.seventeenkouer.da.mapper;

import com.seventeenkouer.da.model.InstoreInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface InstoreInfoMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(InstoreInfo record);

    int insertSelective(InstoreInfo record);

    InstoreInfo selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(InstoreInfo record);

    int updateByPrimaryKey(InstoreInfo record);

    List<InstoreInfo> getTodayInstoreInfo(@Param("loginId") String loginId);

    List<InstoreInfo> getInstoreInfoByMap(Map<String,Object> map);
}