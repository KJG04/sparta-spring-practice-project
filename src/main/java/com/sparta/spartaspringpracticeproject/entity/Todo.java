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
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String title;

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

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "todo")
    List<Comment> comments;

    @Builder
    public Todo(String title, String content, String userName) {
        this.title = title;
        this.content = content;
        this.userName = userName;
    }
}
