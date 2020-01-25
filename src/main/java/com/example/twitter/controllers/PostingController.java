package com.example.twitter.controllers;

import com.example.twitter.model.Posting;
import com.example.twitter.service.PostingService;
import com.example.twitter.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@AllArgsConstructor
public class PostingController {

    private final PostingService postingService;

    @GetMapping(value = "/posts")
    public ModelAndView getUsersView(){
        return new ModelAndView("posts", "allPosts", postingService.getAllPosts());
    }

    @GetMapping(value = "/addpost")
    public ModelAndView getAddPostView(){
        return new ModelAndView("addpost", "postToInsert", new Posting());
    }

    @PostMapping(value="/addpost")
    public String addPost(@ModelAttribute Posting post, HttpSession session){
        postingService.savePost(post,session);
        return "index";


    }
}
