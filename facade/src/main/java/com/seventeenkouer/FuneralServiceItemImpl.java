package com.seventeenkouer;

import com.seventeenkouer.da.mapper.FuneralServiceItemMapper;
import com.seventeenkouer.da.model.FuneralServiceItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xubing.hong on 3/30/2017.
 */
@Service("FuneralServiceItemImpl")
public class FuneralServiceItemImpl implements FuneralServiceItemFace {
    @Autowired
    FuneralServiceItemMapper funeralServiceItemMapper;


    public FuneralServiceItem getById(String id) {

        return funeralServiceItemMapper.selectByPrimaryKey(id);
    }
}
