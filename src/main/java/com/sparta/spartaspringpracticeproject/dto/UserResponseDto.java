package com.sparta.spartaspringpracticeproject.dto;


import com.sparta.spartaspringpracticeproject.entity.UserRole;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserResponseDto {
    Long id;
    String name;
    String email;
    UserRole role;
    LocalDateTime createAt;
    LocalDateTime updateAt;
}
