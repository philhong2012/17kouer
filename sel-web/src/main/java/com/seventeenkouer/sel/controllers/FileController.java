package com.seventeenkouer.sel.controllers;

import com.seventeenkouer.common.constants.ResultCode;
import com.seventeenkouer.common.utils.SystemProperties;
import com.seventeenkouer.web.ResponseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by phil hong
 * User: wind
 * Date: 2018/6/27
 * Time: 下午9:57
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/file")
public class FileController extends BaseController {
    String basePath = SystemProperties.getProperty("upload.url");

    @RequestMapping(value="/upload")
    public ResponseResult upload(@RequestParam MultipartFile[] uploadFiles) {
        List<String> arrFiles = new ArrayList<>(10);
        for(MultipartFile file : uploadFiles) {
            if(file.getSize() > 0) {
                //String fileName = file.getOriginalFilename();
                //201408\180710_1407511489281.jpg
                String fileName = UUID.randomUUID().toString();
                String ext = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
                fileName = fileName +"."+ ext;
                arrFiles.add(fileName);
                File f = new File(basePath,fileName);
                try {
                    file.transferTo(f);
                } catch (IOException e) {
                    //e.printStackTrace();
                    logger.error("上传出错",e);
                    return new ResponseResult(ResultCode.ERROR,arrFiles);
                }
            }
        }
        return new ResponseResult(ResultCode.SUCCESS,arrFiles);
    }
}
