package com.example.todo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Data
@Getter
@Setter

public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "done")
    private boolean done;
    @Column(name = "text")
    private String text;
    @Column(name = "important")
    private Integer important;
}
