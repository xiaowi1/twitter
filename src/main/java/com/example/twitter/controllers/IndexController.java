package com.example.twitter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping(value = {"/", "/index"})
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public String getLoginView(){
        return "login";
    }

    @PostMapping(value = "/logout")
    public String getLogoutView(){
        return "login";
    }

}
