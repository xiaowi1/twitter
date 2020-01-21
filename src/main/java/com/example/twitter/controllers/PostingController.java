package com.example.twitter.controllers;

import com.example.twitter.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class PostingController {
    private final UserService userService;
}
