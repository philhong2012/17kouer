package com.seventeenkouer.sel.controllers;

import com.seventeenkouer.common.constants.ResultCode;
import com.seventeenkouer.common.web.JsonView;
import com.seventeenkouer.facade.SelectCourseFace;
import com.seventeenkouer.facade.dto.SelCourseDto;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
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

    @RequestMapping("/upload")
    public ModelAndView upload() {
        return new ModelAndView("/course/upload");
    }

    @RequestMapping("/save")
    public ModelAndView saveCourse(@RequestBody SelCourseDto selCourse, HttpServletRequest request, HttpServletResponse response) {
        SelCourseDto selCourse1 = selectCourseFace.insertSelective(selCourse);
        return JsonView.dataToJson(selCourse1,response);
    }


    @RequestMapping("/saveUpload")
    public ModelAndView handleFormUpload(@RequestParam("name") String name,
                                   @RequestParam("file") MultipartFile[] files,HttpServletRequest request, HttpServletResponse response) {

        if (files != null && files.length > 0) {

            for (MultipartFile file : files) {

                if (!file.isEmpty()) {
                    OutputStream out = null;
                    InputStream in = null;
                    try {
                        String fileName = file.getOriginalFilename();
                        long sizeInBytes = file.getSize();
                        System.out.println(fileName);
                        System.out.println(sizeInBytes);

                        in = file.getInputStream();
                        byte[] buffer = new byte[1024];
                        int len = 0;
                        //文件最终上传的位置
                        fileName = "e:\\uploadfiles\\" + fileName;

                        System.out.println(fileName);
                         out = new FileOutputStream(fileName);

                        while ((len = in.read(buffer)) != -1) {
                            out.write(buffer, 0, len);
                        }

                        //IOUtils.copy(in,out);

                    } catch (IOException ex) {
                        ex.printStackTrace();
                        return JsonView.addErrorToJson(ResultCode.ERROR,response);
                    } finally {
                        IOUtils.closeQuietly(in);
                        IOUtils.closeQuietly(out);
                    }
                }

            }
        }
        return JsonView.dataToJson(ResultCode.SUCCESS,response);
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
