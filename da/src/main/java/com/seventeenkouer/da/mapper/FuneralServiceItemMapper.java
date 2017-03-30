package com.seventeenkouer.da.mapper;

import com.seventeenkouer.da.model.FuneralServiceItem;

public interface FuneralServiceItemMapper {
    int deleteByPrimaryKey(String serviceItemId);

    int insert(FuneralServiceItem record);

    int insertSelective(FuneralServiceItem record);

    FuneralServiceItem selectByPrimaryKey(String serviceItemId);

    int updateByPrimaryKeySelective(FuneralServiceItem record);

    int updateByPrimaryKey(FuneralServiceItem record);
}