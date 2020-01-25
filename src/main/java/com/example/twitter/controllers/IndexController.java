package com.example.twitter.controllers;

import com.example.twitter.model.Posting;
import com.example.twitter.service.PostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private PostingService postingService;


    @RequestMapping(value = {"/", "/index"})
    public ModelAndView index(Authentication authentication, HttpSession session){
        List<Posting> posts = postingService.getAllPosts();
        String login=authentication.getName();
        session.setAttribute("login",login);
        return new ModelAndView("index", "posts", posts);
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
