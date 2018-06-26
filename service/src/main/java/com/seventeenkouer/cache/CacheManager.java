package com.seventeenkouer.cache;

import com.seventeenkouer.da.model.DrugstoreInfo;
import com.seventeenkouer.da.model.SysUser;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by phil hong
 * User: wind
 * Date: 2018/6/26
 * Time: 上午10:44
 * To change this template use File | Settings | File Templates.
 */
public class CacheManager {
    private final static Map<String,DrugstoreInfo> storeInfoMap = new HashMap<String, DrugstoreInfo>(80000);

    private final static Map<String,SysUser> userInfoMap = new HashMap<String, SysUser>(50000);

    public static void setStoreInfoCache(Map map) {
        if(map != null) {
            storeInfoMap.putAll(map);
        }
    }

    public static Map<String, DrugstoreInfo> getStoreInfoCache() {
       return storeInfoMap;
    }


    public static void putStoreCache(String key,DrugstoreInfo value) {
        storeInfoMap.put(key,value);
    }

    public static DrugstoreInfo getStoreCache(String key,DrugstoreInfo value) {
        return storeInfoMap.get(key);
    }


    public static Map<String,SysUser> getUserInfoCache() {
       return userInfoMap;
    }


    public static void setUserInfoCache(Map map) {
        if(map != null) {
            userInfoMap.putAll(map);
        }
    }



}
