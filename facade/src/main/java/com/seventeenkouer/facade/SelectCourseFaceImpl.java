package com.seventeenkouer.facade;

import com.seventeenkouer.common.mapper.BeanMapper;
import com.seventeenkouer.da.mapper.SelCourseMapper;
import com.seventeenkouer.da.model.SelCourse;
import com.seventeenkouer.facade.dto.SelCourseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.seventeenkouer.common.mybatis.page.Page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by wind on 17/4/5.
 */
@Service("SelectCourseFaceImpl")
public class SelectCourseFaceImpl implements SelectCourseFace {
    @Autowired
    SelCourseMapper selCourseMapper;

    @Override
    public SelCourseDto getById(String courseId) {
        SelCourse selCourse = selCourseMapper.selectByPrimaryKey(courseId);
        return BeanMapper.map(selCourse,SelCourseDto.class);
    }

    @Override
    public SelCourseDto insertSelective(SelCourseDto selCourseDto) {
        SelCourse toInsert = BeanMapper.map(selCourseDto,SelCourse.class);
        if(toInsert != null) {
//            selCourse.setCreatedBy("tester");
            Long curTime = System.currentTimeMillis();
            toInsert.setCourseId(UUID.randomUUID().toString());
            toInsert.setUpdateTime(curTime);
            toInsert.setCreatedTime(curTime);
            selCourseMapper.insertSelective(toInsert);
        }

        return selCourseDto;
    }

    @Override
    public List<SelCourseDto> getByPagination(SelCourseDto selCourseDto) {
        Page page = new Page(selCourseDto.getCurrentPage(), selCourseDto.getPageSize());
        Map<String, Object> params = new HashMap<String, Object>();
        Map params2 = BeanMapper.map(selCourseDto,Map.class);
        params.put("page",page);
        params.putAll(params2);
        List<SelCourse> list = selCourseMapper.selectByPagination(params);
        return BeanMapper.mapList(list,SelCourseDto.class);
    }
}
