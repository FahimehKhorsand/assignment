package com.fahimeh.todo.app.assignment.service;

import com.fahimeh.todo.app.assignment.entity.Todo;
import com.fahimeh.todo.app.assignment.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Todo saveTodo(Todo todo);
    void addTodoToUser(String email, String todoName);
    User getUser(String email);
    List<User> getUser();
}
