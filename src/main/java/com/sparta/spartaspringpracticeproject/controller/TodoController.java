package com.sparta.spartaspringpracticeproject.controller;

import com.sparta.spartaspringpracticeproject.dto.*;
import com.sparta.spartaspringpracticeproject.entity.Todo;
import com.sparta.spartaspringpracticeproject.entity.User;
import com.sparta.spartaspringpracticeproject.entity.UserRole;
import com.sparta.spartaspringpracticeproject.mapper.TodoMapper;
import com.sparta.spartaspringpracticeproject.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
    @Autowired
    TodoService todoService;

    @PostMapping()
    ResponseEntity<TodoResponseDto> createTodo(@Valid @RequestBody CreateTodoRequestDto createTodoRequestDto) {
        Todo todo = todoService.createTodo(createTodoRequestDto.getTitle(), createTodoRequestDto.getContent(), createTodoRequestDto.getUserId());
        return ResponseEntity.status(HttpStatus.CREATED).body(TodoMapper.INSTANCE.toTodoResponseDto(todo));
    }

    @GetMapping("/{todoId}")
    ResponseEntity<TodoResponseDto> getTodoById(@PathVariable Long todoId) {
        Todo todo = todoService.getTodoById(todoId);
        return ResponseEntity.ok(TodoMapper.INSTANCE.toTodoResponseDto(todo));
    }

    @PatchMapping("/{todoId}")
    ResponseEntity<TodoResponseDto> updateTodo(@PathVariable Long todoId, @Valid @RequestBody UpdateTodoRequestDto updateTodoRequestDto, @RequestAttribute("user") User user) {
        if (user.getRole().equals(UserRole.USER))
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "접근 권한이 없습니다.");

        Todo todo = todoService.updateTodo(
                todoId,
                Optional.ofNullable(updateTodoRequestDto.getTitle()),
                Optional.ofNullable(updateTodoRequestDto.getContent()),
                Optional.ofNullable(updateTodoRequestDto.getUserId())
        );
        return ResponseEntity.ok(TodoMapper.INSTANCE.toTodoResponseDto(todo));
    }

    @GetMapping()
    ResponseEntity<PageResponseDto<TodoWithCommentCountResponseDto>> getTodos(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size) {
        Integer pageNumber = Optional.ofNullable(page).orElse(0); // 기본값 0
        Integer pageSize = Optional.ofNullable(size).orElse(10); // 기본값 10
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, Sort.Direction.DESC, "updateAt");
        Page<Todo> todoPage = todoService.getTodos(pageRequest);
        Page<TodoWithCommentCountResponseDto> todoWithCommentCountResponseDtoPage = todoPage.map(TodoMapper.INSTANCE::toTodoWithCommentCountResponseDto);
        PageResponseDto<TodoWithCommentCountResponseDto> pageResponseDto = TodoMapper.INSTANCE.toTodoWithCommentCountResponseDtoPage(todoWithCommentCountResponseDtoPage);
        return ResponseEntity.ok(pageResponseDto);
    }

    @DeleteMapping("/{todoId}")
    ResponseEntity deleteTodo(@PathVariable Long todoId, @RequestAttribute("user") User user) {
        if (user.getRole().equals(UserRole.USER))
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "접근 권한이 없습니다.");

        todoService.deleteTodoById(todoId);
        return ResponseEntity.noContent().build();
    }
}
