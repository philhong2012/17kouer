package com.seventeenkouer.weiapp.controllers;

import com.seventeenkouer.weiapp.webchat.api.user.UserFace;
import com.seventeenkouer.weiapp.webchat.api.user.dto.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wind on 17/4/14.
 */
@Controller
@RequestMapping("weiapi2/tag")
public class TagController {
    //UserTag userTag = new UserTag();
    @Autowired
    UserFace userFaceImpl;
    /**
     * 创建Tag
     * @param tag
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public void create(@RequestBody Tag tag, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String result = userFaceImpl.createUserTag(tag.getName());
        //request.getParameter("tag");
        response.setCharacterEncoding("UTF-8");
        //告诉浏览器或其他的什么查看器,内容的编码是utf-8格式
        response.setContentType("text/html;charset=utf-8"); //设置输出编码格式

        response.getWriter().println(result);
        //return JsonView.dataToJson(selCourse1,response);

    }
}
