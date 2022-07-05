package com.aiit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
    @RequestMapping("/baiduFace")
    public ModelAndView baiduFace(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("baiduFace");
        return modelAndView;
    }
}
