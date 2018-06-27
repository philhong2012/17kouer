package com.seventeenkouer.sel.controllers;

import com.seventeenkouer.common.constants.ResultCode;
import com.seventeenkouer.da.model.DisplayInfo;
import com.seventeenkouer.da.model.InstoreInfo;
import com.seventeenkouer.service.DisplayInfoService;
import com.seventeenkouer.service.InstoreInfoService;
import com.seventeenkouer.web.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 药品陈列控制器
 *
 * @author hongxubing
 * @create 2018-02-11 16:06
 **/
@Controller
@RequestMapping("/display")
public class DisplayInfoController {

    @Autowired
    DisplayInfoService displayInfoService;

    @RequestMapping(method = RequestMethod.POST, value = "/saveDisplay")
    @ResponseBody
    public ResponseResult saveDisplayInfo(@RequestBody
    DisplayInfo displayInfo, HttpServletRequest request, HttpServletResponse response) {
        displayInfoService.saveDisplayInfo(displayInfo);
        return new ResponseResult(ResultCode.SUCCESS,null);
    }
}
