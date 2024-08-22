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

import java.util.List;

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
    ResponseEntity<List<CommentResponseDto>> getComments() {
        List<Comment> commentList = commentService.getAllComments();
        List<CommentResponseDto> commentResponseDtoList = commentList.stream().map(CommentMapper.INSTANCE::toCommentResponseDto).toList();
        return ResponseEntity.ok(commentResponseDtoList);
    }

    @GetMapping("/{commentId}")
    ResponseEntity<CommentResponseDto> getCommentById(@PathVariable Long commentId) {
        Comment comment = commentService.getCommentById(commentId);
        return ResponseEntity.ok(CommentMapper.INSTANCE.toCommentResponseDto(comment));
    }

    @PatchMapping("/{commentId}")
    void updateComment(@PathVariable Long commentId) {
    }

    @DeleteMapping("/{commentId}")
    ResponseEntity deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.noContent().build();
    }
}
