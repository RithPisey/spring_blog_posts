package com.java.blogposts.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native", strategy = "native")
    private int id;

    @Column(name = "firstName")
    private String firstName;
    @Column(name = "middleName")
    private String middleName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "mobile")
    private String mobile;
    @Column(name = "email")
    private String email;
    @Column(name = "passwordHash")
    private String passwordHash;
    @CreatedDate
    @Column(updatable = false, name = "registeredAt")
    private LocalDateTime registeredAt;

    @Column(updatable = false, name = "lastLogin")
    private LocalDateTime lastLogin;
    private String intro;
    private String profile;


}
