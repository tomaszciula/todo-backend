package com.example.todo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "appuser")
@Data

public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "email")
    private String email;
    @Column(name = "pass")
    private String pass;
//    @Column(name = "todos")
//    private Todo[] todos;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "appUser")
//    private Set<Todo> todos;
}
