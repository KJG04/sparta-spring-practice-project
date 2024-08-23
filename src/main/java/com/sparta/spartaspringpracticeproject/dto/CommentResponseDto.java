package com.sparta.spartaspringpracticeproject.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommentResponseDto {
    Long id;
    String content;
    String userName;
    LocalDateTime createAt;
    LocalDateTime updateAt;
}
