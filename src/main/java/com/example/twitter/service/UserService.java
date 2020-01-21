package com.example.twitter.service;

import com.example.twitter.model.Posting;
import com.example.twitter.model.User;
import com.example.twitter.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void savePost(Posting post) {

    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
