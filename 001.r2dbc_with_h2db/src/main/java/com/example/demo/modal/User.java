package com.example.demo.modal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table("users")
public class User {

    @Id
    @Column(value = "ID")
    private Long id;
    @Column(value = "NAME")
    private String name;
    @Column(value = "AGE")
    private Integer age;
    @Column(value = "PROFILE_PICTURE_URL")
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

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
