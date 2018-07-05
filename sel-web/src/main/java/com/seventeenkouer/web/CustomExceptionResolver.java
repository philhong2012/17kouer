package com.seventeenkouer.web;

import com.alibaba.fastjson.JSON;
import com.seventeenkouer.common.constants.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by phil hong
 * User: wind
 * Date: 2018/7/3
 * Time: 下午11:28
 * To change this template use File | Settings | File Templates.
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {

    private static final String APPLICATION_JSON_UTF8 = "application/json;charset=UTF-8";
    private static final String APPLICATION_JSON = "application/json";
    Logger logger = LoggerFactory.getLogger(CustomExceptionResolver.class);
    @Override
    @ResponseBody
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mv = new ModelAndView();
        logger.error("", ex);
        if(request.getContentType() != null && request.getContentType().toLowerCase().indexOf(APPLICATION_JSON) > -1) {


            ResponseResult error = new ResponseResult(ResultCode.ERROR, ex.getMessage());

            String JsonStr = JSON.toJSONString(error);
            //我们发现通过这样的方式设置content-type有可能设置不成功，造成间歇性偶然乱码
            response.setContentType(APPLICATION_JSON_UTF8);
            response.setCharacterEncoding("UTF-8");
            //所以我们强加Content-Type 为 json 格式
            response.addHeader("Content-Type", APPLICATION_JSON_UTF8);
            try {
                response.getWriter().write(JsonStr);
                response.getWriter().flush();
            } catch (IOException e) {
                logger.error("", ex);
            }
            return mv;
        }
        //todo 一个定制的错误页面
        return mv;
    }
}
