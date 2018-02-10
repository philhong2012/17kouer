package com.seventeenkouer.sel.controllers;

import com.seventeenkouer.common.web.JsonView;
import com.seventeenkouer.facade.SelectCourseFace;
import com.seventeenkouer.facade.dto.SelCourseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ${DESCRIPTION}
 * @author
 * @create ${YEAR}-${MONTH}-${DAY} ${TIME}
 **/
@Controller
@RequestMapping("/course")
public class SelController {
    @Autowired
    private SelectCourseFace selectCourseFace;

    @RequestMapping("/create")
    public ModelAndView createCourse() {
        return new ModelAndView("/course/create");
    }

    @RequestMapping("/save")
    public ModelAndView saveCourse(@RequestBody SelCourseDto selCourse, HttpServletRequest request, HttpServletResponse response) {
        SelCourseDto selCourse1 = selectCourseFace.insertSelective(selCourse);
        return JsonView.dataToJson(selCourse1,response);
    }

    @RequestMapping("/list")
    public ModelAndView getCourses(HttpServletRequest request, HttpServletResponse response) {
        SelCourseDto queryParam = new SelCourseDto();
        List<SelCourseDto> selCourse1 = selectCourseFace.getByPagination(queryParam);

        Map<String,Object> model = new HashMap<>();
        model.put("list",selCourse1);
        return new ModelAndView("/course/list",model);
    }
}
