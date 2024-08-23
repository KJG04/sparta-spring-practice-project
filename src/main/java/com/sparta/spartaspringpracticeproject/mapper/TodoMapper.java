package com.sparta.spartaspringpracticeproject.mapper;

import com.sparta.spartaspringpracticeproject.dto.PageResponseDto;
import com.sparta.spartaspringpracticeproject.dto.TodoResponseDto;
import com.sparta.spartaspringpracticeproject.dto.TodoWithCommentCountResponseDto;
import com.sparta.spartaspringpracticeproject.entity.Todo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

@Mapper
public interface TodoMapper {
    TodoMapper INSTANCE = Mappers.getMapper(TodoMapper.class);

    TodoResponseDto toTodoResponseDto(Todo todo);

    @Mapping(expression = "java(todo.getComments().size())", target = "commentCount")
    TodoWithCommentCountResponseDto toTodoWithCommentCountResponseDto(Todo todo);

    @Mapping(source = "content", target = "content", defaultExpression = "java(java.util.List.of())")
    PageResponseDto<TodoWithCommentCountResponseDto> toTodoWithCommentCountResponseDtoPage(Page<TodoWithCommentCountResponseDto> todoWithCommentCountResponseDtoPage);
}
