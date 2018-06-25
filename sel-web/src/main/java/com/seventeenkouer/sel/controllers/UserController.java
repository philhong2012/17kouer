package com.seventeenkouer.sel.controllers;

import com.seventeenkouer.common.constants.ResultCode;
import com.seventeenkouer.da.model.SysUser;
import com.seventeenkouer.service.SysUserService;
import com.seventeenkouer.web.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    SysUserService sysUserService;


    //todo:tong
    @RequestMapping(method = RequestMethod.POST, value = "/validate")
    @ResponseBody
    public ResponseResult validate(@RequestBody SysUser userDto, HttpServletRequest request, HttpServletResponse response) {
        if (sysUserService.validateUser(userDto.getFloginid(), userDto.getFpassword())) {
            request.getSession().setAttribute("username", userDto.getFename());
        }

        return new ResponseResult(ResultCode.SUCCESS,null);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    @ResponseBody
    public ResponseResult login(@RequestBody SysUser userDto, HttpServletRequest request, HttpServletResponse response) {
        if (sysUserService.validateUser(userDto.getFloginid(), userDto.getFpassword())) {
            request.getSession().setAttribute("username", userDto.getFename());
        }

        return new ResponseResult(ResultCode.SUCCESS,null);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public ModelAndView login(HttpServletResponse response) {
       return  new ModelAndView("user/login",null);
    }
}
