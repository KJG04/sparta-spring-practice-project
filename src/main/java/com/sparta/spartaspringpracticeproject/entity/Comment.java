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

    @ManyToOne
    @JoinColumn(name = "todo_id")
    @Column
    Todo todo;
    
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
    public Comment(String content, String userName) {
        this.content = content;
        this.userName = userName;
    }
}
