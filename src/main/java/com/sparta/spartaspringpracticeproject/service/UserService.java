package com.sparta.spartaspringpracticeproject.service;

import com.sparta.spartaspringpracticeproject.config.JwtUtil;
import com.sparta.spartaspringpracticeproject.config.PasswordEncoder;
import com.sparta.spartaspringpracticeproject.entity.User;
import com.sparta.spartaspringpracticeproject.entity.UserRole;
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

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtUtil jwtUtil;

    public User createUser(String name, String email, String password, UserRole role) {
        if (userRepository.findByEmail(email).isPresent())
            throw new ResponseStatusException(HttpStatus.CONFLICT, "해당하는 email을 가지는 User가 이미 존재합니다.");

        String encodedPassword = passwordEncoder.encode(password);
        User user = User.builder().name(name).email(email).password(encodedPassword).role(role).build();
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 userId를 가지는 User가 없습니다."));
    }

    public User updateUser(Long userId, Optional<String> name, Optional<String> email, Optional<UserRole> role) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "해당 userId를 가지는 User가 없습니다."));

        name.ifPresent(user::setName);
        email.ifPresent(user::setEmail);
        role.ifPresent(user::setRole);

        return userRepository.save(user);
    }

    public void deleteUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 userId를 가지는 User가 없습니다."));
        userRepository.delete(user);
    }

    public String createAccessToken(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 userId를 가지는 User가 없습니다."));
        return jwtUtil.createToken(user.getId(), user.getRole());
    }

    private final ResponseStatusException abstractLoginFailException = new ResponseStatusException(HttpStatus.UNAUTHORIZED, "email 또는 password가 일치하지 않습니다.");

    public User loginUser(String email, String password) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> abstractLoginFailException);
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw abstractLoginFailException;
        }
        return user;
    }
}
