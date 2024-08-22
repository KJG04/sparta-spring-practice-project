package com.sparta.spartaspringpracticeproject.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "TODO_ID", nullable = false)
    Todo todo;

    @Column(nullable = false)
    String content;

    @Column(nullable = false)
    String userName;

    @Column(nullable = false)
    @CreatedDate
    LocalDateTime createAt;

    @Column(nullable = false)
    @LastModifiedDate
    LocalDateTime updateAt;

    @Builder
    public Comment(String content, String userName, Todo todo) {
        this.content = content;
        this.userName = userName;
        this.todo = todo;
    }
}
