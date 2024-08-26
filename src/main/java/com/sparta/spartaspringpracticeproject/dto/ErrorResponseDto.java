package com.sparta.spartaspringpracticeproject.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorResponseDto {
    String timestamp;
    int status;
    String error;
    String message;
    String path;
}
