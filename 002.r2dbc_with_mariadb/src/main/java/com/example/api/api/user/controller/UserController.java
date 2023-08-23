package com.example.api.api.user.controller;

import com.example.api.api.user.model.User;
import com.example.api.api.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    // Read
    @GetMapping("users")
    public Flux<User> findAll() {
        return userService.findAll();
    }
}
