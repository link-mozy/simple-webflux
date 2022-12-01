package com.example.demo.controller;

import com.example.demo.modal.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UserApiController {
    private final UserService userService;

    // Read
    @GetMapping("users")
    public Flux<User> findAll() {
        return userService.findAll();
    }

    // Create
    @PostMapping(value = "users", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<User> addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    // Update
    @PutMapping(value = "users", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<User> updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    // Delete
    @DeleteMapping(value = "user/{id}")
    public Mono<Void> deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}
