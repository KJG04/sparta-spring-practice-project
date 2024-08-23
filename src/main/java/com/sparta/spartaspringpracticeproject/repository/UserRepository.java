package com.sparta.spartaspringpracticeproject.repository;

import com.sparta.spartaspringpracticeproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
