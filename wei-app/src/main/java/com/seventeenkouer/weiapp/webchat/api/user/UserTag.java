package com.seventeenkouer.weiapp.webchat.api.user;

import com.alibaba.fastjson.JSON;
import com.seventeenkouer.common.web.NetWorkHelper;
import com.seventeenkouer.weiapp.webchat.accesstoken.TokenThread;
import com.seventeenkouer.weiapp.webchat.api.user.dto.Tag;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wind on 17/4/14.
 */
public class UserTag {
   private  String url = "https://api.weixin.qq.com/cgi-bin/tags/create?access_token="+ TokenThread.accessToken.getAccessToken();

   public String createUserTag(String tagName) {
       Tag tag = new Tag();
       tag.setName("广东");
       Map<String,Tag> map = new HashMap<>();
       map.put("tag", tag);
       String json = JSON.toJSONString(map);
       System.out.println("创建Tag,post数据: " + json);
       NetWorkHelper netWorkHelper = new NetWorkHelper();

       String result = netWorkHelper.PostHttpsResponse(url,json);

       return result;
   }

}
