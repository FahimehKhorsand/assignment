package com.fahimeh.todo.app.assignment.repository;

import com.fahimeh.todo.app.assignment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
