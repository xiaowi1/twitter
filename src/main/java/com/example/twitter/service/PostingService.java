package com.example.twitter.service;

import com.example.twitter.model.Posting;
import com.example.twitter.model.User;
import com.example.twitter.repository.PostingRepository;
import com.example.twitter.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PostingService {

    @Autowired
    private UserService userService;

    private final PostingRepository postingRepository;


    public User getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = authentication.getName();
        return userService.getUserByLogin(login);
    }

    public void savePost(Posting post) {
        post.setUser(getUser());
        postingRepository.save(post);    }
}
