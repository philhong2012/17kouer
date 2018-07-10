package com.seventeenkouer.da.mapper;

import com.seventeenkouer.da.model.DrugstoreInfo;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
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

    /**
     * 获取distance范围内的药店
     * @param longitude 经度
     * @param latitude 纬度
     * @param distance 距离（米）
     * @return 药店列表
     */
    List<DrugstoreInfo> getNearByStores(@Param("longitude") BigDecimal longitude, @Param("latitude") BigDecimal latitude, @Param("distance") Long distance);
}