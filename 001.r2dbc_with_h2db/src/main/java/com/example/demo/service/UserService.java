package com.example.demo.service;

import com.example.demo.modal.User;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public Mono<Long> count() {
        return userRepository.count();
    }

    public Flux<User> findAll() {
        return userRepository.findAll();
    }

    public Mono<User> findUser(Long id) {
        return userRepository.findById(id);
    }

    public Mono<User> addUser(User user) {
        User newUser = User.builder()
                .name(user.getName())
                .age(user.getAge())
                .updatedAt(LocalDateTime.now())
                .createdAt(LocalDateTime.now())
                .build();
        return userRepository.save(newUser);
    }

    public Flux<User> addUsers(Flux<User> users) {
        return userRepository.saveAll(users);
    }

    public Mono<User> updateUser(User user) {
        return findUser(user.getId()).map(u -> {
                    if(user.getAge() != null) u.setAge(user.getAge());
                    if(user.getName() != null) u.setName(user.getName());
                    u.setUpdatedAt(LocalDateTime.now());
                    return u;
                })
                .flatMap(userRepository::save)
                .switchIfEmpty(Mono.error(new Exception("user update fail")));
    }

    public Mono<Void> deleteUser(Long id) {
        return userRepository.deleteById(id);
    }

    public Mono<Void> deleteAll() {
        return userRepository.deleteAll();
    }
}
