package com.seventeenkouer.sel.controllers;

import com.seventeenkouer.common.Exception.SeventeenkouException;
import com.seventeenkouer.common.constants.ResultCode;
import com.seventeenkouer.da.model.DrugstoreInfo;
import com.seventeenkouer.da.model.SysUser;
import com.seventeenkouer.service.DrugstoreInfoService;
import com.seventeenkouer.service.SysUserService;
import com.seventeenkouer.web.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 药店控制器
 *
 * @author hongxubing
 * @create 2018-02-11 16:06
 **/
@Controller
@RequestMapping("/drugstore")
public class DrugstoreController {

    Logger logger = LoggerFactory.getLogger(DrugstoreController.class);

    @Autowired
    DrugstoreInfoService drugstoreInfoService;

    @RequestMapping(method = RequestMethod.POST, value = "/nearBy")
    @ResponseBody
    public ResponseResult getNearByStores(@RequestBody DrugstoreInfo drugstoreInfo, HttpServletRequest request, HttpServletResponse response) {
        Long stateTime = System.currentTimeMillis();
        List<DrugstoreInfo> nearbyStores = drugstoreInfoService.getStoresByCoordinate(drugstoreInfo.getPointx().toString(),
                drugstoreInfo.getPointy().toString(),1L);
        logger.debug("获取周边药店耗时{}秒",(System.currentTimeMillis() - stateTime) / 1000);
        return new ResponseResult(ResultCode.SUCCESS,nearbyStores);

    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveStoreInfo")
    @ResponseBody
    public ResponseResult saveStoreInfo(@RequestBody DrugstoreInfo drugstoreInfo, HttpServletRequest request, HttpServletResponse response) {
        drugstoreInfoService.saveStore(drugstoreInfo);
        return new ResponseResult(ResultCode.SUCCESS,drugstoreInfo);

    }
    @RequestMapping(method = RequestMethod.GET, value = "/store/{id}")
    @ResponseBody
    public ResponseResult getStoreInfo(@PathVariable("id") Integer id, HttpServletRequest request, HttpServletResponse response) {
        DrugstoreInfo drugstoreInfo = drugstoreInfoService.getStoreByKey(id);
        return new ResponseResult(ResultCode.SUCCESS,drugstoreInfo);
    }
}
