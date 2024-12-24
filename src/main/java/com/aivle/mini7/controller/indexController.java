package com.aivle.mini7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class indexController {
    @GetMapping("/")
    public String index(){
        return "Emergency/index";
    }

    @GetMapping("/search")
    public String search(@RequestParam String message, @RequestParam String latitude, @RequestParam String longitude,
            @RequestParam String hospitals, Model model){
        model.addAttribute("message", message);
        model.addAttribute("latitude", latitude);
        model.addAttribute("longitude", longitude);
        model.addAttribute("hospitals", hospitals);
        return "Emergency/result";
    }
}