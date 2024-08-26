package com.sparta.spartaspringpracticeproject.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TodoWithCommentCountResponseDto {
    Long id;
    String title;
    String content;
    Integer commentCount;
    LocalDateTime createAt;
    LocalDateTime updateAt;
}
