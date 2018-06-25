package com.seventeenkouer.da.mapper;

import com.seventeenkouer.da.model.DrugInfo;

public interface DrugInfoMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(DrugInfo record);

    int insertSelective(DrugInfo record);

    DrugInfo selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(DrugInfo record);

    int updateByPrimaryKey(DrugInfo record);
}