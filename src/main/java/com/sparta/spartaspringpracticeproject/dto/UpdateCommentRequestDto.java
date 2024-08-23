package com.sparta.spartaspringpracticeproject.dto;


import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UpdateCommentRequestDto {
    String content;
    String userName;
}
