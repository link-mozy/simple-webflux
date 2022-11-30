package com.example.demo;

import com.example.demo.modal.User;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDateTime;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        User user1 = User.builder().name("test1").age(10).updatedAt(LocalDateTime.now()).createdAt(LocalDateTime.now()).build();
        User user2 = User.builder().name("test2").age(20).updatedAt(LocalDateTime.now()).createdAt(LocalDateTime.now()).build();
        User user3 = User.builder().name("test3").age(30).updatedAt(LocalDateTime.now()).createdAt(LocalDateTime.now()).build();

        userRepository.deleteAll()
                .and(userRepository.saveAll(Flux.just(user1, user2, user3)))
                .subscribe();
    }

    @AfterEach
    void tearDown() {
        userRepository.deleteAll().subscribe();
    }

    @Test
    @DisplayName("사용자 테이블 deleteAll 테스트")
    public void whenDeleteAllThen0IsExpected() {
        userRepository.deleteAll()
                .as(StepVerifier::create)
                .expectNextCount(0)
                .verifyComplete();
    }

    @Test
    @DisplayName("사용자 테이블 findAll 테스트")
    public void whenFindAllThen3AreExpected() {
        userRepository.findAll()
                .as(StepVerifier::create)
                .expectNextCount(3)
                .verifyComplete();
    }

    @Test
    @DisplayName("사용자 테이블 추가 테스트")
    public void whenInserThen1AreExpected() {
        // given
        User user = User.builder()
                .name("test")
                .age(20)
                .updatedAt(LocalDateTime.now())
                .createdAt(LocalDateTime.now())
                .build();

        // when
        userRepository.deleteAll();
        Mono<User> u = userRepository.save(user);

        // then
        StepVerifier.create(u)
                .assertNext(it -> {
                    Assertions.assertEquals(user.getName(), it.getName());
                    Assertions.assertEquals(user.getAge(), it.getAge());
                    Assertions.assertEquals(user.getCreatedAt(), it.getCreatedAt());
                    Assertions.assertEquals(user.getUpdatedAt(), it.getUpdatedAt());
                })
                .verifyComplete();
    }
}
