package com.sparta.spartaspringpracticeproject.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "password은 빈 값이 아니여야 합니다.")
    @Size(min = 8, message = "password는 8글자 이상이여야 합니다.")
    String password;
}
