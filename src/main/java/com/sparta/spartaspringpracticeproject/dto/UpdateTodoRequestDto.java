package com.sparta.spartaspringpracticeproject.dto;


import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UpdateTodoRequestDto {
    String title;

    String content;

    String userName;
}
