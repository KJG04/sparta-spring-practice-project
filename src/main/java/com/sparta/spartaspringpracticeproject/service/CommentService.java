package com.sparta.spartaspringpracticeproject.service;

import com.sparta.spartaspringpracticeproject.entity.Comment;
import com.sparta.spartaspringpracticeproject.entity.Todo;
import com.sparta.spartaspringpracticeproject.repository.CommentRepository;
import com.sparta.spartaspringpracticeproject.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    @Autowired
    TodoRepository todoRepository;

    public Comment createComment(String content, String userName, Long todoId) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "todoId 해당하는 Todo를 찾을 수 없습니다."));
        Comment comment = Comment.builder().todo(todo).content(content).userName(userName).build();
        return commentRepository.save(comment);
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Comment getCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "commentId 해당하는 Comment를 찾을 수 없습니다."));
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    public Comment updateComment(Long commentId, Optional<String> content, Optional<String> userName) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "todoId 해당하는 Todo를 찾을 수 없습니다."));
        content.ifPresent(comment::setContent);
        userName.ifPresent(comment::setUserName);
        return commentRepository.save(comment);
    }
}
