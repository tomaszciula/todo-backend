package com.example.todo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "note")
@Data
@Getter
@Setter

public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;

}
