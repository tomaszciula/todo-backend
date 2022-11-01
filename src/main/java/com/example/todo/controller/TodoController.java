package com.example.todo.controller;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class TodoController {

    @Autowired
    TodoRepository todoRepository;

    @GetMapping("/todos")
    List<Todo> all() {
        return todoRepository.findAll();
    }
    @PostMapping("/todos")
    Todo newTodo(@RequestBody Todo newTodo) {
        return todoRepository.save(newTodo);
    }
    @PutMapping("/todos/{id}")
    Todo updateTodo(@RequestBody Todo newTodo, @PathVariable Long id) {
        return todoRepository.findById(id).map(item -> {
            item.setDone(newTodo.isDone());
            item.setText(newTodo.getText());
            item.setImportant(newTodo.getImportant());
            return todoRepository.save(item);
        })
                .orElseGet(() -> {
                    newTodo.setId(id);
                    return todoRepository.save(newTodo);
                });
    }
    @DeleteMapping("/todos/{id}")
    void deleteTodo(@PathVariable Long id) {
        todoRepository.deleteById(id);
    }
}
