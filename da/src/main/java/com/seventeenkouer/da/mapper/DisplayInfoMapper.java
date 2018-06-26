package com.seventeenkouer.da.mapper;

import com.seventeenkouer.da.model.DisplayInfo;

public interface DisplayInfoMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(DisplayInfo record);

    int insertSelective(DisplayInfo record);

    DisplayInfo selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(DisplayInfo record);

    int updateByPrimaryKey(DisplayInfo record);
}