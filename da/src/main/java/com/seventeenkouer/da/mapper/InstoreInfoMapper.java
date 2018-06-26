package com.seventeenkouer.da.mapper;

import com.seventeenkouer.da.model.InstoreInfo;

public interface InstoreInfoMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(InstoreInfo record);

    int insertSelective(InstoreInfo record);

    InstoreInfo selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(InstoreInfo record);

    int updateByPrimaryKey(InstoreInfo record);
}