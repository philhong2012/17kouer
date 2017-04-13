package com.seventeenkouer.weiapp.webchat.accesstoken;

/**
 * Created by huzhicheng on 2015/11/5.
 * 参考:http://www.cnblogs.com/fengzheng/p/5027630.html
 */
public class AccessToken {
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getExpiresin() {
        return expiresin;
    }

    public void setExpiresin(int expiresin) {
        this.expiresin = expiresin;
    }

    private String accessToken;

    private int expiresin;
}
