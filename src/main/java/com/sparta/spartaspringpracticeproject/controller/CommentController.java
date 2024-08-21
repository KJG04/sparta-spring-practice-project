package com.sparta.spartaspringpracticeproject.controller;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/comments")
public class CommentController {
    @PostMapping()
    void createComment() {
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
