package com.seventeenkouer.facade;

import com.seventeenkouer.da.model.SelCourse;
import com.seventeenkouer.facade.dto.CourseDto;

import java.util.List;
import java.util.Map;

/**
 * Created by wind on 17/4/5.
 */
public interface SelectCourseFace {
    SelCourse getById(String courseId);
    SelCourse insertSelective(SelCourse selCourse);
    List<SelCourse> getByPagination(CourseDto courseDto);
}
