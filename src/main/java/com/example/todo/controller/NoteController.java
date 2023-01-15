package com.example.todo.controller;

import com.example.todo.model.Note;
import com.example.todo.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")

public class NoteController {
    @Autowired
    NoteRepository noteRepository;

    @GetMapping("/notes")
    List<Note> all() {
        return noteRepository.findAll();
    }

    @PostMapping("/notes")
    Note newNote(@RequestBody Note newNote) {
        return noteRepository.save(newNote);
    }

    @PutMapping("/notes/{id}")
    Note updateNote(@RequestBody Note newNote, @PathVariable Long id) {
        return noteRepository.findById(id).map(item -> {
                    item.setTitle(newNote.getTitle());
                    item.setContent(newNote.getContent());
                    return noteRepository.save(item);
                })
                .orElseGet(() -> {
                    newNote.setId(id);
                    return noteRepository.save(newNote);
                });
    }

    @DeleteMapping("/notes/{id}")
    void deleteNote(@PathVariable Long id) {
        noteRepository.deleteById(id);
    }
}