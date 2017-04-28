package com.seventeenkouer.weiapp.webchat.api.user;


import org.springframework.stereotype.Service;

/**
 * Created by wind on 17/4/18.
 */
@Service("userFaceImpl")
public class UserFaceImpl implements UserFace{

    //private  String url = "https://api.weixin.qq.com/cgi-bin/tags/create?access_token="+ TokenThread.accessToken.getAccessToken();


    @Override
    public String createUserTag(String tagName) {
//        Tag tag = new Tag();
//        tag.setName("广东");
//        Map<String,Tag> map = new HashMap<>();
//        map.put("tag", tag);
//        String json = JSON.toJSONString(map);
//        System.out.println("创建Tag,post数据: " + json);
//        NetWorkHelper netWorkHelper = new NetWorkHelper();
//
//        String result = netWorkHelper.PostHttpsResponse(url,json);
//
//        return result;
        return  "";
    }
}
