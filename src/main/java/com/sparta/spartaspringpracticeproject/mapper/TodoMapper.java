package com.sparta.spartaspringpracticeproject.mapper;

import com.sparta.spartaspringpracticeproject.dto.TodoResponseDto;
import com.sparta.spartaspringpracticeproject.entity.Todo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TodoMapper {
    TodoMapper INSTANCE = Mappers.getMapper(TodoMapper.class);

    TodoResponseDto toTodoResponseDto(Todo todo);
}
