package com.sparta.spartaspringpracticeproject.service;

import com.sparta.spartaspringpracticeproject.entity.User;
import com.sparta.spartaspringpracticeproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User createUser(String name, String email) {
        User user = User.builder().name(name).email(email).build();
        return userRepository.save(user);
    }
}
