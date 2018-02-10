package com.seventeenkouer.facade;

import com.seventeenkouer.facade.dto.SelCourseDto;

import java.util.List;

/**
 * Created by wind on 17/4/5.
 */
public interface SelectCourseFace {
    /**
     *
     * @param courseId
     * @return
     */
    SelCourseDto getById(String courseId);

    /**
     *
     * @param selCourseDto
     * @return
     */
    SelCourseDto insertSelective(SelCourseDto selCourseDto);

    /**
     *
     * @param selCourseDto
     * @return
     */
    List<SelCourseDto> getByPagination(SelCourseDto selCourseDto);
}
