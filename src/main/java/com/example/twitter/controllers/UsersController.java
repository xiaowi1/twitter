package com.example.twitter.controllers;

import com.example.twitter.model.User;
import com.example.twitter.service.UserService;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public ModelAndView getUsersView(){
        return new ModelAndView("users", "allUsers", userService.getAllUsers());
    }

    @GetMapping(value = "/adduser")
    public ModelAndView getAddUserView(){
        return new ModelAndView("adduser", "userToInsert", new User());
    }

    @PostMapping(value="/adduser")
    public String addUser(@ModelAttribute User user){
        userService.saveUser(user);
        return "index";
    }

    @PostMapping(value="/userdetails")
    public String userDetails(@ModelAttribute User user) {
        System.out.println(user.getName() + " " + user.getSurname());
        return "index";
    }

}
