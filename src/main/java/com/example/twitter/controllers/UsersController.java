package com.example.twitter.controllers;

import com.example.twitter.model.User;
import com.example.twitter.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@AllArgsConstructor
@Slf4j
public class UsersController {
    private final UserService userService;

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
        log.info(user.getName() + " " + user.getSurname());
        return "index";
    }

}
