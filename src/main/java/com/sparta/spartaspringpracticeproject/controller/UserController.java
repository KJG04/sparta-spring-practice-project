package com.sparta.spartaspringpracticeproject.controller;

import com.sparta.spartaspringpracticeproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()
    void getUsers() {
    }

    @PostMapping()
    void createUser() {
    }

    @GetMapping("/{userId}")
    void getUserById(@PathVariable Long userId) {
    }

    @PatchMapping("/{userId}")
    void updateUser(@PathVariable Long userId) {
    }

    @DeleteMapping("/{userId}")
    void deleteUser(@PathVariable Long userId) {
    }
}
