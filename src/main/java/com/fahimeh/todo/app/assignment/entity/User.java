package com.fahimeh.todo.app.assignment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.AUTO;


@Entity @Data @NoArgsConstructor @AllArgsConstructor
@Table(name ="USER",schema = "public")
public class User {

    @Id
//    @Column(name ="ID", nullable = false, updatable = false)
    @GeneratedValue(strategy = AUTO)
    private Long id;
//    @Column(name="EMAIL", nullable = true)
    private String email;
//    @Column(name="PASSWORD", nullable = true)
    private String password;

    @ManyToMany (fetch = EAGER)
//    @OneToMany (cascade = CascadeType.ALL)
//    @JoinColumn(name = "ut_fk",referencedColumnName = "user_id")
    private Collection<Todo> todos = new ArrayList<>();

}
