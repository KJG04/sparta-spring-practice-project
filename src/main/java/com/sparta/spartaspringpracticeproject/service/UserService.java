package com.sparta.spartaspringpracticeproject.service;

import com.sparta.spartaspringpracticeproject.entity.User;
import com.sparta.spartaspringpracticeproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User createUser(String name, String email) {
        if (userRepository.findByEmail(email).isPresent())
            throw new ResponseStatusException(HttpStatus.CONFLICT, "해당하는 email을 가지는 User가 이미 존재합니다.");

        User user = User.builder().name(name).email(email).build();
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 userId를 가지는 User가 없습니다."));
    }

    public User updateUser(Long userId, Optional<String> name, Optional<String> email) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "해당 userId를 가지는 User가 없습니다."));

        name.ifPresent(user::setName);
        email.ifPresent(user::setEmail);

        return userRepository.save(user);
    }

    public void deleteUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 userId를 가지는 User가 없습니다."));
        userRepository.delete(user);
    }
}
