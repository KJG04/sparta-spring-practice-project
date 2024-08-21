package com.sparta.spartaspringpracticeproject.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TodoResponseDto {
    Long id;
    String title;
    String content;
    String userName;
    LocalDateTime createAt;
    LocalDateTime updateAt;
}
