package com.seventeenkouer.sel.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xubing.hong on 2/22/2017.
 */
@Controller
@RequestMapping("/hello")
public class helloController  {

    @RequestMapping("/greeting")
    public ModelAndView hello(@RequestParam("name") String name) {
        Map model = new HashMap<>();
        model.put("name",name);
        return  new ModelAndView("hello",model);
    }
}
