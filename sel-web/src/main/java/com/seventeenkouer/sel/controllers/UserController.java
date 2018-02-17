package com.seventeenkouer.sel.controllers;

import com.seventeenkouer.common.constants.ResultCode;
import com.seventeenkouer.common.web.JsonView;
import com.seventeenkouer.facade.UserFace;
import com.seventeenkouer.facade.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ${DESCRIPTION}
 *
 * @author hongxubing
 * @create 2018-02-11 16:06
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserFace userFace;

    @RequestMapping(method = RequestMethod.POST, value = "/validate")
    public ModelAndView validate(@RequestBody UserDto userDto, HttpServletRequest request,HttpServletResponse response) {
        try {
            userFace.login(userDto);
            request.getSession().setAttribute("username",userDto.getLoginName());
        } catch (Exception e) {
            e.printStackTrace();
            return JsonView.addErrorToJson(ResultCode.ERROR,response);
        }
        return JsonView.dataToJson(null,response);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public ModelAndView login(HttpServletResponse response) {
       return  new ModelAndView("user/login",null);
    }
}
