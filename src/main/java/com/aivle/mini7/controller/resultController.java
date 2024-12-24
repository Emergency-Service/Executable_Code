package com.aivle.mini7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class resultController {
    @GetMapping("/re_input")
    public String re_input(){
        return "Emergency/index";
    }
}
