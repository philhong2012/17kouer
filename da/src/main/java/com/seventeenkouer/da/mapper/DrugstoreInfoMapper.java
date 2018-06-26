package com.seventeenkouer.da.mapper;

import com.seventeenkouer.da.model.DrugstoreInfo;

import java.util.List;

public interface DrugstoreInfoMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(DrugstoreInfo record);

    int insertSelective(DrugstoreInfo record);

    DrugstoreInfo selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(DrugstoreInfo record);

    int updateByPrimaryKey(DrugstoreInfo record);

    List<DrugstoreInfo> selectAll();

    List<DrugstoreInfo> selectByPagination();
}