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
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String title;

    @Column
    String content;

    @Column
    String userName;

    @Column
    @CreatedDate
    LocalDateTime createAt;

    @Column
    @LastModifiedDate
    LocalDateTime updateAt;

    @Builder
    public Todo(String title, String content, String userName) {
        this.title = title;
        this.content = content;
        this.userName = userName;
    }
}
