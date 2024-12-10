package com.example.module309.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView response = new ModelAndView();

        // this is our index.jsp
        response.setViewName("index");

        return response;
    }

}
