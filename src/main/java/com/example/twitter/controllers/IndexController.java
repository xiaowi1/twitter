package com.example.twitter.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @RequestMapping(value = {"/", "/index"})
    public String index(Authentication authentication, HttpSession session){
        String login=authentication.getName();
        session.setAttribute("login",login);
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
