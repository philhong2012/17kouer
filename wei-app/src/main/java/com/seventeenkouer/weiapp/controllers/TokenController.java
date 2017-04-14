package com.seventeenkouer.weiapp.controllers;

import com.seventeenkouer.common.utils.WebchatUtils;
import com.seventeenkouer.weiapp.webchat.message.MessageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/**
 * Created by wind on 17/4/12.
 */

@Controller
@RequestMapping("/weiapi")
public class TokenController {
    Logger logger = LoggerFactory.getLogger(TokenController.class);

    /**
     * 校验微信token
     * @param
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST}, value = "/check")
    public void check(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean isGet = request.getMethod().equalsIgnoreCase("get");
        if(isGet) {
            String signature = request.getParameter("signature");
            String timestamp = request.getParameter("timestamp");
            String nonce = request.getParameter("nonce");
            String echostr = request.getParameter("echostr");

            if(WebchatUtils.checkToken(signature,timestamp,nonce,echostr)) {
                response.getWriter().println(echostr);
            }
        } else {
            //Post:处理微信消息
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=utf-8"); //设置输出编码格式
            String result = "";
            try {
                Map map = MessageHandler.parseXml(request);
                System.out.println("开始构造消息");
                result = MessageHandler.buildXml(map, response);



                System.out.println(result);
                if(result.equals(""))
                    result = "未正确响应";
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("发生异常："+ e.getMessage());
            }
            response.getWriter().println(result);
        }
    }

    /**
     * 排序
     * @param token
     * @param timestamp
     * @param nonce
     * @return
     */
    public static String sort(String token, String timestamp, String nonce) {
        String[] strArray = { token, timestamp, nonce };
        Arrays.sort(strArray);

        StringBuilder sbuilder = new StringBuilder();
        for (String str : strArray) {
            sbuilder.append(str);
        }

        return sbuilder.toString();
    }
}
