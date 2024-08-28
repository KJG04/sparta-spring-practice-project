package com.sparta.spartaspringpracticeproject.controller;

import com.sparta.spartaspringpracticeproject.dto.*;
import com.sparta.spartaspringpracticeproject.entity.User;
import com.sparta.spartaspringpracticeproject.mapper.UserMapper;
import com.sparta.spartaspringpracticeproject.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()
    ResponseEntity<List<UserResponseDto>> getUsers() {
        return ResponseEntity.ok(userService.getUsers().stream().map(UserMapper.INSTANCE::toUserResponseDto).toList());
    }

    @PostMapping()
    ResponseEntity<AuthUserResponseDto> createUser(@Valid @RequestBody CreateUserRequestDto createUserRequestDto) {
        User user = userService.createUser(createUserRequestDto.getName(), createUserRequestDto.getEmail(), createUserRequestDto.getPassword(), createUserRequestDto.getRole());
        String accessToken = userService.createAccessToken(user.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.INSTANCE.toRegisterUserResponseDto(user, accessToken));
    }

    @GetMapping("/{userId}")
    ResponseEntity<UserResponseDto> getUserById(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(UserMapper.INSTANCE.toUserResponseDto(user));
    }

    @PatchMapping("/{userId}")
    ResponseEntity<UserResponseDto> updateUser(@PathVariable Long userId, @RequestBody @Valid UpdateUserRequestDto updateUserRequestDto) {
        User user = userService.updateUser(userId, Optional.ofNullable(updateUserRequestDto.getName()), Optional.ofNullable(updateUserRequestDto.getEmail()), Optional.ofNullable(updateUserRequestDto.getRole()));
        return ResponseEntity.ok(UserMapper.INSTANCE.toUserResponseDto(user));
    }

    @DeleteMapping("/{userId}")
    ResponseEntity deleteUser(@PathVariable Long userId) {
        userService.deleteUserById(userId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    ResponseEntity<AuthUserResponseDto> loginUser(@RequestBody @Valid LoginUserRequestDto loginUserRequestDto) {
        User user = userService.loginUser(loginUserRequestDto.getEmail(), loginUserRequestDto.getPassword());
        String accessToken = userService.createAccessToken(user.getId());
        return ResponseEntity.ok(UserMapper.INSTANCE.toRegisterUserResponseDto(user, accessToken));
    }
}
