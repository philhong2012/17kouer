package com.seventeenkouer.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by wind on 17/4/13.
 */
public class WebchatUtils {
    static Logger logger = LoggerFactory.getLogger(WebchatUtils.class);
    private static String TOKEN = "17kouer";
    public static boolean checkToken(String signature,String timestamp,String nonce,String echostr) {
        logger.debug("开始签名校验 signature:{} timestamp:{},nonce:{},echostr:{}",
                signature,timestamp,nonce,echostr);

        ArrayList<String> array = new ArrayList<String>();
        array.add(signature);
        array.add(timestamp);
        array.add(nonce);

        //排序
        String sortString = sort(TOKEN, timestamp, nonce);
        //加密
        String mytoken = Decript.SHA1(sortString);
        //校验签名
        if (mytoken != null && mytoken != "" && mytoken.equals(signature)) {
            logger.debug("签名校验通过。");
            //response.getWriter().println(echostr);
            return true;
        } else {
            logger.debug("签名校验失败。");
            return false;
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
