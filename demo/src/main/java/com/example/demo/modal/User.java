package com.example.demo.modal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table("users")
public class User {

    @Id
    private Long id;
    private String name;
    private Integer age;
    private String profilePictureUrl;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @CreatedDate
    private LocalDateTime createdAt;

    @Builder
    public User(String name, Integer age, String profilePictureUrl, LocalDateTime updatedAt, LocalDateTime createdAt) {
        this.name = name;
        this.age = age;
        this.profilePictureUrl = profilePictureUrl;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }
}
