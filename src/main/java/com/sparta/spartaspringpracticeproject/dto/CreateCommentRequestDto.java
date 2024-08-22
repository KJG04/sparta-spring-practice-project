package com.sparta.spartaspringpracticeproject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateCommentRequestDto {
    @NotBlank(message = "content은 빈 값이 아니여야 합니다.")
    String content;

    @NotBlank(message = "userName은 빈 값이 아니여야 합니다.")
    String userName;

    @NotNull(message = "todoId는 null이 아니여야 합니다.")
    Long todoId;
}
