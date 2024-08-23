package com.sparta.spartaspringpracticeproject.dto;


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
    LocalDateTime createAt;
    LocalDateTime updateAt;
}
