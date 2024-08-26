package com.sparta.spartaspringpracticeproject.dto;

import com.sparta.spartaspringpracticeproject.entity.User;
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
    User user;
    LocalDateTime createAt;
    LocalDateTime updateAt;
}
