package com.seventeenkouer.sel.controllers;

import com.seventeenkouer.common.constants.ResultCode;
import com.seventeenkouer.da.model.DrugInfo;
import com.seventeenkouer.service.DrugInfoService;
import com.seventeenkouer.web.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by phil hong
 * User: wind
 * Date: 2018/9/7
 * Time: 下午9:07
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/drugInfo")
public class DrugInfoController {
    @Autowired
    DrugInfoService drugInfoService;
    @RequestMapping(method = RequestMethod.GET, value = "/drugInfoByCode/{drugBcode}")
    @ResponseBody
    public ResponseResult getDrugInfoByCode(@PathVariable("drugBcode") String drugBcode, HttpServletRequest request, HttpServletResponse response) {
        DrugInfo drugInfo =drugInfoService.selectByCode(drugBcode);
        return new ResponseResult(ResultCode.SUCCESS,drugInfo);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/drugInfoByCode2/{drugCode}")
    @ResponseBody
    public ResponseResult getDrugInfoByCode2(@PathVariable("drugCode") String drugCode, HttpServletRequest request, HttpServletResponse response) {
        DrugInfo drugInfo =drugInfoService.selectByCode2(drugCode);
        return new ResponseResult(ResultCode.SUCCESS,drugInfo);
    }
}
