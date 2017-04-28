package com.seventeenkouer.multithread;


import com.alibaba.fastjson.JSON;
import com.seventeenkouer.common.web.HttpClientUtil;
import com.seventeenkouer.dto.SelCourseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

/**
 * Created by wind on 17/4/27.
 */
public class MyThread extends Thread {
    public static String url = "http://localhost:8080/selweb/hello/saveSelCourse";
    Logger logger = LoggerFactory.getLogger(this.getClass());

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        SelCourseDto selCourseDto = new SelCourseDto();
        selCourseDto.setCourseId(UUID.randomUUID().toString());
        selCourseDto.setCourseCode(this.getName());
        selCourseDto.setCourseName(this.getName());
        selCourseDto.setCreatedBy(this.getName());

        //NetWorkHelper.getInstance().PostHttpsResponse(url, JSON.toJSONString(selCourseDto));
        //List<String>  arr = new ArrayList<>(1000);
        //logger.info("thread name :  {} ; thread id {} " ,this.getName(),this.getId() );
        HttpClientUtil.sendHttpPostJson(url,JSON.toJSONString(selCourseDto));
        System.out.printf("thread name :  %s ; thread id %d \n" ,this.getName(),this.getId());
    }
}
