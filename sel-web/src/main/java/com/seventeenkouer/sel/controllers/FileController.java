package com.seventeenkouer.sel.controllers;

import com.seventeenkouer.common.constants.ResultCode;
import com.seventeenkouer.common.utils.SystemProperties;
import com.seventeenkouer.web.ResponseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

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
    @ResponseBody
    public ResponseResult upload(@RequestParam MultipartFile[] uploadFiles,
                                 @RequestParam String loginId) {
        List<String> arrFiles = new ArrayList<>(10);
        for(MultipartFile file : uploadFiles) {
            if(file.getSize() > 0) {
                //String fileName = file.getOriginalFilename();
                //201408\180710_1407511489281.jpg
                String datePath = createFolderByDate(basePath);
                String fileName = Paths.get(datePath,loginId + "-" + UUID.randomUUID().toString()).toString();
                String ext = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
                fileName = fileName +"."+ ext;
                arrFiles.add(fileName);
                File f = new File(fileName);
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


    public static void main(String[] args) {
        createFolderByDate("/Users/wind/work");
    }



    private static String createFolderByDate(String basePath) {
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
        Calendar calendar = Calendar.getInstance();
        //String fileName = format.format(calendar.getTime());
        //String fullPath = basePath+ File.separator + fileName;
        Integer year = calendar.get(calendar.YEAR);
        //String yearPath = basePath + File.separator + year.toString()+ File.separator;
        //createFolder(yearPath);
        Integer month = calendar.get(calendar.MONTH);
        Integer day = calendar.get(calendar.DATE);
        //String datePath = basePath + File.separator + year.toString() +
                //File.separator + month.toString() + "-" + day.toString() + File.separator;
        //createFolder(datePath);

        String yearPath = Paths.get(basePath,year.toString()/*,month.toString() + "-" + day.toString()*/).toString();
        String datePath = Paths.get(basePath,year.toString(),month.toString() + "-" + day.toString()).toString();
        createFolder(yearPath);
        createFolder(datePath);
        //String p = "/wind//fwe/fwef";
        //String p1 = Paths.get(p).toString();
        return datePath;
    }


    private static String createFolder(String path) {
        File dir = new File(path);
        if(!dir.exists()) {
            dir.mkdir();
        }
        return path;
    }
}
