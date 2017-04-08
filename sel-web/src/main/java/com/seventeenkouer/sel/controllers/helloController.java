package com.seventeenkouer.sel.controllers;

import com.seventeenkouer.facade.SelectCourseFace;
import com.seventeenkouer.common.web.JsonView;
import com.seventeenkouer.da.model.SelCourse;
import com.seventeenkouer.facade.dto.CourseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xubing.hong on 2/22/2017.
 */
@Controller
@RequestMapping("/hello")
public class helloController  {
    @Autowired
    SelectCourseFace selectCourseFace;

    @RequestMapping("/greeting")
    public ModelAndView hello(@RequestParam("name") String name) {
        Map model = new HashMap<>();
        model.put("name",name);

        //test
        return  new ModelAndView("hello",model);
    }

    /**
     * 获取课程
     * @param selCourse
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/getSelCourse")
    public ModelAndView getCourse(@ModelAttribute SelCourse selCourse, HttpServletRequest request, HttpServletResponse response) {
        SelCourse selCourse1 = selectCourseFace.getById(selCourse.getCourseId());
        return JsonView.dataToJson(selCourse1,response);

    }


    /**
     * 分页获取课程
     * @param courseDto
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/getByPagination")
    public ModelAndView getByPagination(@ModelAttribute CourseDto courseDto, HttpServletRequest request, HttpServletResponse response) {
        List<SelCourse> courses = selectCourseFace.getByPagination(courseDto);
        return JsonView.dataToJson(courses,response);

    }

    /**
     * 保存课程
     * @param selCourse
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/saveSelCourse")
    public ModelAndView saveCourse(@RequestBody SelCourse selCourse, HttpServletRequest request, HttpServletResponse response) {
        SelCourse selCourse1 = selectCourseFace.insertSelective(selCourse);
        return JsonView.dataToJson(selCourse1,response);

    }
}