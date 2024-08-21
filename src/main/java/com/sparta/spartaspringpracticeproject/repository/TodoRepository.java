package com.sparta.spartaspringpracticeproject.repository;


import com.sparta.spartaspringpracticeproject.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
