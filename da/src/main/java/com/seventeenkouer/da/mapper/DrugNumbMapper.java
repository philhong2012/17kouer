package com.seventeenkouer.da.mapper;

import com.seventeenkouer.da.model.DrugNumb;

public interface DrugNumbMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DrugNumb record);

    int insertSelective(DrugNumb record);

    DrugNumb selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DrugNumb record);

    int updateByPrimaryKey(DrugNumb record);
}