package com.sparta.spartaspringpracticeproject.repository;


import com.sparta.spartaspringpracticeproject.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    @Override
    @EntityGraph(attributePaths = {"comments"})
    Page<Todo> findAll(Pageable pageable);
}
