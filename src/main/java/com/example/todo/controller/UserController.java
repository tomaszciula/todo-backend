package com.example.todo.controller;

import com.example.todo.model.AppUser;
import com.example.todo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    List<AppUser> all() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    AppUser newUser(@RequestBody AppUser newUser) {
        return userRepository.save(newUser);
    }

    @PutMapping("/users/{id}")
    AppUser updateUser(@RequestBody AppUser newUser, @PathVariable Long id) {
        return userRepository.findById(id).map(item -> {
                    item.setEmail(newUser.getEmail());
                    item.setFirstname(newUser.getFirstname());
                    item.setLastname(newUser.getLastname());
                    item.setPass(newUser.getPass());
                    return userRepository.save(item);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return userRepository.save(newUser);
                });
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
