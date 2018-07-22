package com.seventeenkouer.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.OutputStream;

/**
 * 如果没有注入默认的日期格式，也没有配置<value>WriteDateUseDateFormat</value>, 也没有属性注解@JSONField(format="yyyy-MM-dd hh:mm:ss") 则会转换输出时间戳
 * 如果只配置<value>WriteDateUseDateFormat</value>，则会转换输出yyyy-MM-dd hh:mm:ss
 * 配置<value>WriteDateUseDateFormat</value>, 属性注解@JSONField(format="yyyy-MM-dd hh:mm:ss") 则会转换输出为属性注解的格式
 * 如果注入了默认的日期格式，属性注解@JSONField(format="yyyy-MM-dd hh:mm:ss") 则会转换输出为属性注解的格式
 * 如果注入了默认的日期格式，则会转换输出为默认的日期格式
 * 如果三者都配置则会转换成属性注解的格式
 * Created by PETER on 2016/2/5.
 */
public class CustomerFastJsonHttpMessageConverter extends FastJsonHttpMessageConverter {

    public static SerializeConfig mapping = new SerializeConfig();

    private String defaultDateFormat;

    @Override
    protected void writeInternal(Object obj, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        OutputStream out = outputMessage.getBody();
        String text = JSON.toJSONString(obj, mapping, super.getFeatures());
        byte[] bytes = text.getBytes(getCharset());
        out.write(bytes);
    }

    public void setDefaultDateFormat(String defaultDateFormat) {
        mapping.put(java.util.Date.class, new SimpleDateFormatSerializer(defaultDateFormat));
    }
}
