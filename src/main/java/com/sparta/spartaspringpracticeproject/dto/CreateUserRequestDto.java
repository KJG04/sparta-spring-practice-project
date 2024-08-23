package com.sparta.spartaspringpracticeproject.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateUserRequestDto {
    @NotBlank(message = "name은 빈 값이 아니여야 합니다.")
    String name;

    @NotBlank(message = "email은 빈 값이 아니여야 합니다.")
    @Email(message = "email은 이메일 형식이여야 합니다.")
    String email;
}
