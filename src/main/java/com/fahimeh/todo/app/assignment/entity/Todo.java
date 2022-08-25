package com.fahimeh.todo.app.assignment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "TODO")
public class Todo {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;

}
