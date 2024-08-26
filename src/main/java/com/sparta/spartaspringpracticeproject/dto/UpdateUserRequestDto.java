package com.sparta.spartaspringpracticeproject.dto;


import jakarta.validation.constraints.Email;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UpdateUserRequestDto {
    String name;

    @Email(message = "email은 이메일 형식이여야 합니다.")
    String email;
}
