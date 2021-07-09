package com.example.case_study_springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @GetMapping({"", "home"})
    public ModelAndView goHome(){
        return new ModelAndView("home");
    }
}
