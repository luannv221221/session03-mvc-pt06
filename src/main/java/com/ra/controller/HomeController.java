package com.ra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(){
        // trả về view
        return "home";
    }
    @RequestMapping("/about")
    public String about(){
        return "about";
    }

}
