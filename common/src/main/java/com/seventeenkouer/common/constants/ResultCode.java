package com.seventeenkouer.common.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * 业务操作结果编码
 *
 * @author hongxubing
 * @create 2018-02-11 10:19
 **/
public class ResultCode {
    public final static String SUCCESS = "001";
    public final static String ERROR = "002";



    private final static Map<String, String> codeMessage = new HashMap<>();

    static {
        codeMessage.put(SUCCESS,"保存成功");
        codeMessage.put(ERROR,"保存失败");
    }
}
