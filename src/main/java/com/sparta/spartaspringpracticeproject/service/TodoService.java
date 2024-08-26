package com.sparta.spartaspringpracticeproject.service;

import com.sparta.spartaspringpracticeproject.entity.Todo;
import com.sparta.spartaspringpracticeproject.entity.User;
import com.sparta.spartaspringpracticeproject.repository.TodoRepository;
import com.sparta.spartaspringpracticeproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    TodoRepository todoRepository;

    @Autowired
    UserRepository userRepository;

    public Todo createTodo(String title, String content, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "userId 해당하는 User를 찾을 수 없습니다."));
        Todo todo = Todo.builder().title(title).content(content).user(user).build();
        return todoRepository.save(todo);
    }

    public Todo getTodoById(Long todoId) {
        return todoRepository.findById(todoId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "todoId 해당하는 Todo를 찾을 수 없습니다."));
    }

    public Todo updateTodo(Long todoId, Optional<String> title, Optional<String> content, Optional<Long> userId) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "todoId 해당하는 Todo를 찾을 수 없습니다."));

        title.ifPresent(todo::setTitle);
        content.ifPresent(todo::setContent);
        userId.ifPresent((Long _userId) -> {
            User user = userRepository.findById(_userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "userId 해당하는 User를 찾을 수 없습니다."));
            todo.setUser(user);
        });

        return todoRepository.save(todo);
    }

    public Page<Todo> getTodos(Pageable pageable) {
        return todoRepository.findAll(pageable);
    }

    public void deleteTodoById(Long todoId) {
        todoRepository.delete(todoRepository.findById(todoId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "todoId 해당하는 Todo를 찾을 수 없습니다.")));
    }
}
