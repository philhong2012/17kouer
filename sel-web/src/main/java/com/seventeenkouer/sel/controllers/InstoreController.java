package com.seventeenkouer.sel.controllers;

import com.seventeenkouer.common.constants.ResultCode;
import com.seventeenkouer.da.model.DrugstoreInfo;
import com.seventeenkouer.da.model.InstoreInfo;
import com.seventeenkouer.service.InstoreInfoService;
import com.seventeenkouer.web.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 寻店控制器
 *
 * @author hongxubing
 * @create 2018-02-11 16:06
 **/
@Controller
@RequestMapping("/instore")
public class InstoreController {

    @Autowired
    InstoreInfoService instoreInfoService;

    @RequestMapping(method = RequestMethod.POST, value = "/saveInstore")
    @ResponseBody
    public ResponseResult saveInstore(@RequestBody InstoreInfo instoreInfo, HttpServletRequest request, HttpServletResponse response) {
        instoreInfoService.saveInstoreInfo(instoreInfo);
        return new ResponseResult(ResultCode.SUCCESS,null);
    }



    @RequestMapping(method = RequestMethod.GET, value = "/todayInstoreInfo/{loginId}")
    @ResponseBody
    public ResponseResult getTodayInstoreInfo(@PathVariable("loginId") String loginId, HttpServletRequest request, HttpServletResponse response) {
        List<InstoreInfo> instoreInfos = instoreInfoService.getTodayInstoreInfo(loginId);
        return new ResponseResult(ResultCode.SUCCESS,instoreInfos);
    }

}
