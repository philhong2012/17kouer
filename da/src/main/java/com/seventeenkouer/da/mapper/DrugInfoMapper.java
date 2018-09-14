package com.seventeenkouer.da.mapper;

import com.seventeenkouer.da.model.DrugInfo;
import org.apache.ibatis.annotations.Param;

public interface DrugInfoMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(DrugInfo record);

    int insertSelective(DrugInfo record);

    DrugInfo selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(DrugInfo record);

    int updateByPrimaryKey(DrugInfo record);

    DrugInfo selectByCode(@Param("drugBcode") String drugBcode);

    DrugInfo selectByCode2(@Param("drugCode") String drugCode);
}