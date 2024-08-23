package com.sparta.spartaspringpracticeproject.dto;

import lombok.*;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PageResponseDto<T> {
    Integer totalPages;
    Integer totalElements;
    Boolean first;
    Boolean last;
    Integer size;
    List<T> content;
    Integer numberOfElements;
    Boolean empty;
}
