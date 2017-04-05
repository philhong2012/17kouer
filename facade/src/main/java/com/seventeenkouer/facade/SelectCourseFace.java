package com.seventeenkouer.facade;

import com.seventeenkouer.da.model.SelCourse;

/**
 * Created by wind on 17/4/5.
 */
public interface SelectCourseFace {
    SelCourse getById(String courseId);
}
