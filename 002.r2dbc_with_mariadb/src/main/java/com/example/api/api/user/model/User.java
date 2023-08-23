package com.example.api.api.user.model;

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
    @Column(value = "IDX")
    private Long idx;
    @Column(value = "ID")
    private String id;
    @Column(value = "NAME")
    private String name;
    @Column(value = "PHONE")
    private String phone;
    @Column(value = "EMAIL")
    private String email;
    @Column(value = "SEX")
    private String sex;
    @Column(value = "BIRT_DATE")
    private String birtDate;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @CreatedDate
    private LocalDateTime createdAt;

    @Builder
    public User(String id, String name, String phone, String email, String sex, String birtDate, LocalDateTime updatedAt, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.sex = sex;
        this.birtDate = birtDate;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setBirtDate(String birtDate) {
        this.birtDate = birtDate;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
