package com.sparta.spartaspringpracticeproject.controller;

import com.sparta.spartaspringpracticeproject.dto.CommentResponseDto;
import com.sparta.spartaspringpracticeproject.dto.CreateCommentRequestDto;
import com.sparta.spartaspringpracticeproject.entity.Comment;
import com.sparta.spartaspringpracticeproject.mapper.CommentMapper;
import com.sparta.spartaspringpracticeproject.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping()
    ResponseEntity<CommentResponseDto> createComment(@Valid @RequestBody CreateCommentRequestDto createCommentRequestDto) {
        Comment comment = commentService.createComment(createCommentRequestDto.getContent(), createCommentRequestDto.getUserName(), createCommentRequestDto.getTodoId());
        return ResponseEntity.status(HttpStatus.CREATED).body(CommentMapper.INSTANCE.toCommentResponseDto(comment));
    }

    @GetMapping()
    void getComments() {
    }

    @GetMapping("/{commentId}")
    void getCommentById(@PathVariable String commentId) {
    }

    @PatchMapping("/{commentId}")
    void updateComment(@PathVariable String commentId) {
    }

    @DeleteMapping("/{commentId}")
    void deleteComment(@PathVariable String commentId) {
    }
}
