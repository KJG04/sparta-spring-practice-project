package com.sparta.spartaspringpracticeproject.controller;

import com.sparta.spartaspringpracticeproject.dto.CreateTodoRequestDto;
import com.sparta.spartaspringpracticeproject.dto.TodoResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
    @PostMapping()
    ResponseEntity<TodoResponseDto> createTodo(@Valid @RequestBody CreateTodoRequestDto createTodoRequestDto) {
        return ResponseEntity.ok(TodoResponseDto.builder().build());
    }

    @GetMapping("/{todoId}")
    ResponseEntity<TodoResponseDto> getTodoById(@PathVariable String todoId) {
        return ResponseEntity.ok(TodoResponseDto.builder().build());
    }

    @PutMapping("/{todoId}")
    ResponseEntity<TodoResponseDto> updateTodo(@PathVariable String todoId) {
        return ResponseEntity.ok(TodoResponseDto.builder().build());
    }
}
