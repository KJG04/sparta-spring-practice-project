package com.sparta.spartaspringpracticeproject.service;

import com.sparta.spartaspringpracticeproject.entity.Todo;
import com.sparta.spartaspringpracticeproject.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TodoService {
    @Autowired
    TodoRepository todoRepository;

    public Todo createTodo(String title, String content, String userName) {
        Todo todo = Todo.builder().title(title).content(content).userName(userName).build();
        return todoRepository.save(todo);
    }

    public Todo getTodoById(Long todoId) {
        return todoRepository.findById(todoId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "todoId 해당하는 Todo를 찾을 수 없습니다."));
    }
}
