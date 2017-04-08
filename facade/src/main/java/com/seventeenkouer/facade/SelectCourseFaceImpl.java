package com.seventeenkouer.facade;

import com.seventeenkouer.common.mapper.BeanMapper;
import com.seventeenkouer.da.mapper.SelCourseMapper;
import com.seventeenkouer.da.model.SelCourse;
import com.seventeenkouer.facade.dto.CourseDto;
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

    public SelCourse getById(String courseId) {
        return selCourseMapper.selectByPrimaryKey(courseId);
    }

    public SelCourse insertSelective(SelCourse selCourse) {
        if(selCourse != null) {
//            selCourse.setCreatedBy("tester");
            Long curTime = System.currentTimeMillis();
            selCourse.setCourseId(UUID.randomUUID().toString());
            selCourse.setUpdateTime(curTime);
            selCourse.setCreatedTime(curTime);
            selCourseMapper.insertSelective(selCourse);
        }

        return selCourse;
    }

    public List<SelCourse> getByPagination(CourseDto courseDto) {
        Page page = new Page(courseDto.getCurrentPage(),courseDto.getPageSize());
        Map<String, Object> params = new HashMap<String, Object>();
        Map params2 = BeanMapper.map(courseDto,Map.class);
        params.put("page",page);
        params.putAll(params2);
        return selCourseMapper.selectByPagination(params);
    }
}
