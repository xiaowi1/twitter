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

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
@AllArgsConstructor
public class PostingService {

    @Autowired
    private UserService userService;

    private final PostingRepository postingRepository;


    public User getUser(HttpSession session) {
        return userService.getUserByLogin(session.getAttribute("login").toString());
    }

    public void savePost(Posting post,HttpSession session) {
        post.setUser(getUser(session));
        postingRepository.save(post);    }


    public List<Posting> getAllPosts(){
        return postingRepository.findAll();
    }
}
