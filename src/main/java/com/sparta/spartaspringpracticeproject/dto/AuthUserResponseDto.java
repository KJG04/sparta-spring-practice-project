package com.sparta.spartaspringpracticeproject.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthUserResponseDto {
    UserResponseDto user;
    String accessToken;
}
