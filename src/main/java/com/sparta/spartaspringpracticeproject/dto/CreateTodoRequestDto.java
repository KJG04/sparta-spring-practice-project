package com.sparta.spartaspringpracticeproject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateTodoRequestDto {
    @NotBlank(message = "title은 빈 값이 아니여야 합니다.")
    String title;

    @NotBlank(message = "content은 빈 값이 아니여야 합니다.")
    String content;

    @NotNull(message = "userName은 null이 아니여야 합니다.")
    Long userId;
}
