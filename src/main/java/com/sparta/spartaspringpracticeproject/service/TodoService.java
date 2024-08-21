package com.sparta.spartaspringpracticeproject.service;

import com.sparta.spartaspringpracticeproject.entity.Todo;
import com.sparta.spartaspringpracticeproject.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    TodoRepository todoRepository;

    public Todo createTodo(String title, String content, String userName) {
        Todo todo = Todo.builder().title(title).content(content).userName(userName).build();
        return todoRepository.save(todo);
    }
}
