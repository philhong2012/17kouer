package com.seventeenkouer.sel.controllers;

import com.seventeenkouer.FuneralServiceItemFace;
import com.seventeenkouer.common.web.JsonView;
import com.seventeenkouer.da.model.FuneralServiceItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xubing.hong on 2/22/2017.
 */
@Controller
@RequestMapping("/hello")
public class helloController  {
    @Autowired
    FuneralServiceItemFace funeralServiceItemFace;

    @RequestMapping("/greeting")
    public ModelAndView hello(@RequestParam("name") String name) {
        Map model = new HashMap<>();
        model.put("name",name);

        //test
        return  new ModelAndView("hello",model);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/getServiceItem")
    public ModelAndView getServiceItem(@RequestParam("name") String name,HttpServletRequest request,HttpServletResponse response) {
        FuneralServiceItem funeralServiceItem = funeralServiceItemFace.getById("");
        return JsonView.dataToJson(funeralServiceItem,response);

    }
}