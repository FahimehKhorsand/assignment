package com.fahimeh.todo.app.assignment.service;

import com.fahimeh.todo.app.assignment.entity.Todo;
import com.fahimeh.todo.app.assignment.entity.User;
import com.fahimeh.todo.app.assignment.repository.TodoRepository;
import com.fahimeh.todo.app.assignment.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final TodoRepository todoRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user==null){
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        }else{
            log.info("User found in the database:{}",email);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getTodos().forEach(todo -> {
            authorities.add(new SimpleGrantedAuthority(todo.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),authorities);
    }
    @Override
    public User saveUser(User user) {
        log.info("Saving new user {} to the database",user.getEmail());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Todo saveTodo(Todo todo) {
        log.info("Saving new todo {} to the database",todo.getName());
        return todoRepository.save(todo);
    }

    @Override
    public void addTodoToUser(String email, String todoName) {
    log.info("Saving new todo {} to user {}",todoName,email);
    User user = userRepository.findByEmail(email);
    Todo todo = todoRepository.findByName(todoName);
    user.getTodos().add(todo);
    }

    @Override
    public User getUser(String email) {
        log.info("Fetching user {}",email);
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> getUser() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }


}
