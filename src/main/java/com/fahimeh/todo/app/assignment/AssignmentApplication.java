package com.fahimeh.todo.app.assignment;

import com.fahimeh.todo.app.assignment.entity.Todo;
import com.fahimeh.todo.app.assignment.entity.User;
import com.fahimeh.todo.app.assignment.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;



@SpringBootApplication
public class AssignmentApplication  {


    public static void main(String[] args) {
        SpringApplication.run(AssignmentApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

     @Bean(name = "UserService")
     CommandLineRunner run(UserService userService){
    return args -> {

            userService.saveTodo(new Todo(null,"TODO_CLICK"));
            userService.saveTodo(new Todo(null,"TODO_SCORE"));
            userService.saveTodo(new Todo(null,"TODO_SHORTCUT"));
            userService.saveTodo(new Todo(null,"TODO_AVAYA"));
            userService.saveTodo(new Todo(null,"TODO_JIRA"));

            userService.saveUser(new User(null,"khorsand.fahimeh@yahoo.com","1234",new ArrayList<>()));
            userService.saveUser(new User(null,"manavi.sarem@yahoo.com","1111",new ArrayList<>()));
            userService.saveUser(new User(null,"khorsand.peiman@yahoo.com","1234",new ArrayList<>()));
            userService.saveUser(new User(null,"khorsand.fatemeh@yahoo.com","1234",new ArrayList<>()));

            userService.addTodoToUser("khorsand.fahimeh@yahoo.com","TODO_CLICK");
            userService.addTodoToUser("manavi.sarem@yahoo.com","TODO_SCORE");
            userService.addTodoToUser("manavi.sarem@yahoo.com","TODO_CLICK");
            userService.addTodoToUser("khorsand.peiman@yahoo.com","TODO_AVAYA");
            userService.addTodoToUser("khorsand.fatemeh@yahoo.com","TODO_SHORTCUT");
            userService.addTodoToUser("khorsand.fahimeh@yahoo.com","TODO_JIRA");
   };
}
}

            