package com.sparta.spartaspringpracticeproject.dto;

import com.sparta.spartaspringpracticeproject.entity.Todo;
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
    Todo todo;
    LocalDateTime createAt;
    LocalDateTime updateAt;
}
