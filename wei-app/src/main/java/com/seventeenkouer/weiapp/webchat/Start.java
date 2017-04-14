package com.seventeenkouer.weiapp.webchat;

/**
 * Created by huzhicheng on 2015/12/7.
 */


import com.seventeenkouer.common.utils.WebchatUtils;
import com.seventeenkouer.weiapp.webchat.message.MessageHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

public class Start extends HttpServlet {

    //token
    private final String token = "17kouer";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("开始签名校验");
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");

        if(WebchatUtils.checkToken(signature,timestamp,nonce,echostr)) {
            response.getWriter().println(echostr);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8"); //设置输出编码格式
        System.out.println("请求进入");
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
