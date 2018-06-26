package com.seventeenkouer.sel.controllers;

import com.seventeenkouer.common.constants.ResultCode;
import com.seventeenkouer.da.model.DrugstoreInfo;
import com.seventeenkouer.da.model.SysUser;
import com.seventeenkouer.service.DrugstoreInfoService;
import com.seventeenkouer.service.SysUserService;
import com.seventeenkouer.web.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author hongxubing
 * @create 2018-02-11 16:06
 **/
@Controller
@RequestMapping("/drugstore")
public class DrugstoreController {

    @Autowired
    DrugstoreInfoService drugstoreInfoService;

    //todo:tong
    @RequestMapping(method = RequestMethod.POST, value = "/validate")
    @ResponseBody
    public ResponseResult validate(@RequestBody SysUser userDto, HttpServletRequest request, HttpServletResponse response) {


        return new ResponseResult(ResultCode.SUCCESS,null);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/nearBy")
    @ResponseBody
    public ResponseResult getNearByStores(@RequestBody DrugstoreInfo drugstoreInfo, HttpServletRequest request, HttpServletResponse response) {
        List<DrugstoreInfo> nearbyStores = drugstoreInfoService.getStoresByCoordinate(drugstoreInfo.getPointx().toString(),
                drugstoreInfo.getPointy().toString(),1L);

        return new ResponseResult(ResultCode.SUCCESS,nearbyStores);


    }


    @RequestMapping(method = RequestMethod.GET, value = "/store/{id}")
    @ResponseBody
    public ResponseResult getStoreInfo(@PathVariable("id") Integer id, HttpServletRequest request, HttpServletResponse response) {
        DrugstoreInfo drugstoreInfo = drugstoreInfoService.getStoreByKey(id);
        return new ResponseResult(ResultCode.SUCCESS,drugstoreInfo);
    }
}
