package com.fahimeh.todo.app.assignment.repository;

import com.fahimeh.todo.app.assignment.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,Long> {
     Todo findByName(String name);
}
