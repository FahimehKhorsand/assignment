package com.fahimeh.todo.app.assignment.controller;

import com.fahimeh.todo.app.assignment.entity.Todo;
import com.fahimeh.todo.app.assignment.entity.User;
import com.fahimeh.todo.app.assignment.repository.TodoRepository;
import com.fahimeh.todo.app.assignment.repository.UserRepository;
import com.fahimeh.todo.app.assignment.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>>getUsers(){
        return ResponseEntity.ok().body(userService.getUser());
    }

    @GetMapping("/user/save")
    public ResponseEntity<User>saveUser(@RequestBody User user){
      URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }
    @GetMapping("/todo/save")
    public ResponseEntity<Todo>saveTodo(@RequestBody Todo todo){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/todo/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveTodo(todo));
    }

    @PostMapping("/todo/addtouser")
    public ResponseEntity<?>addTodoToUser(@RequestBody TodoToUserForm form){
      userService.addTodoToUser(form.getEmail(), form.getTodoName());
      return ResponseEntity.ok().build();
    }
}
@Data
class TodoToUserForm{
  private String email;
  private String todoName;
}
