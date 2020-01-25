package com.example.twitter.controllers;

import com.example.twitter.service.PostingService;
import com.example.twitter.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class PostingController {

    @Autowired
    private final UserService userService;

    private final PostingService postingService;

}
