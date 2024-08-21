package com.sparta.spartaspringpracticeproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
    @PostMapping()
    void postTodo() {}

    @GetMapping("/{todoId}")
    void getTodoById(@PathVariable String todoId) {}

    @PutMapping("/{todoId}")
    void updateTodo(@PathVariable String todoId){}
}
