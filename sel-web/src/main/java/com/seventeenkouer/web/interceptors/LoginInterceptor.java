package com.seventeenkouer.web.interceptors;

import com.seventeenkouer.common.utils.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by phil hong
 * User: wind
 * Date: 18/2/17
 * Time: 下午4:37
 * To change this template use File | Settings | File Templates.
 * 该拦截器对移动端无法做鉴权的,移动端请求后端接口没有所谓的session概念,服务器是无状态的.可以借助redis存储session实现对移动端调用api的鉴权操作
 */
public class LoginInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求的URL
       /* String url = request.getRequestURI();
        String debug = request.getParameter("debug");
        if(StringUtils.isNotEmpty(debug)){
            return true;
        }
        //URL:login.jsp是公开的;这个demo是除了login.jsp是可以公开访问的，其它的URL都进行拦截控制
        if(url.indexOf("login")>=0 || url.indexOf("validate") >=0 || url.indexOf("debug") >= 0){
            return true;
        }

        //获取Session
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");

        if(username != null){
            return true;
        }
        //不符合条件的，跳转到登录界面
        request.getRequestDispatcher("/WEB-INF/views/user/login.jsp").forward(request, response);

        return false;*/
       return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
