package com.seventeenkouer.facade;

import com.seventeenkouer.da.mapper.SelCourseMapper;
import com.seventeenkouer.da.model.SelCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
