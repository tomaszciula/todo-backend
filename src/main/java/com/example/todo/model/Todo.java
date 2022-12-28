package com.example.todo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "todo")
@Data
@Getter
@Setter

public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id")
    private Long id;
    @Column(name = "done")
    private boolean done;
    @Column(name = "text")
    private String text;
    @Column(name = "important")
    private Integer important;

    @ManyToOne
    @JoinColumn(name = "appuser_id")
    private AppUser appUser;
}
