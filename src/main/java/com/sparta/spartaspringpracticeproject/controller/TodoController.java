package com.sparta.spartaspringpracticeproject.controller;

import com.sparta.spartaspringpracticeproject.dto.CreateTodoRequestDto;
import com.sparta.spartaspringpracticeproject.dto.TodoResponseDto;
import com.sparta.spartaspringpracticeproject.dto.UpdateTodoRequestDto;
import com.sparta.spartaspringpracticeproject.entity.Todo;
import com.sparta.spartaspringpracticeproject.mapper.TodoMapper;
import com.sparta.spartaspringpracticeproject.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
    @Autowired
    TodoService todoService;

    @PostMapping()
    ResponseEntity<TodoResponseDto> createTodo(@Valid @RequestBody CreateTodoRequestDto createTodoRequestDto) {
        Todo todo = todoService.createTodo(createTodoRequestDto.getTitle(), createTodoRequestDto.getContent(), createTodoRequestDto.getUserName());
        return ResponseEntity.status(HttpStatus.CREATED).body(TodoMapper.INSTANCE.toTodoResponseDto(todo));
    }

    @GetMapping("/{todoId}")
    ResponseEntity<TodoResponseDto> getTodoById(@PathVariable Long todoId) {
        Todo todo = todoService.getTodoById(todoId);
        return ResponseEntity.ok(TodoMapper.INSTANCE.toTodoResponseDto(todo));
    }

    @PatchMapping("/{todoId}")
    ResponseEntity<TodoResponseDto> updateTodo(@PathVariable Long todoId, @RequestBody UpdateTodoRequestDto updateTodoRequestDto) {
        Todo todo = todoService.updateTodo(
                todoId,
                Optional.ofNullable(updateTodoRequestDto.getTitle()),
                Optional.ofNullable(updateTodoRequestDto.getContent()),
                Optional.ofNullable(updateTodoRequestDto.getUserName())
        );
        return ResponseEntity.ok(TodoMapper.INSTANCE.toTodoResponseDto(todo));
    }
}
