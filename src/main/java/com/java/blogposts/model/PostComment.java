package com.java.blogposts.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@Table(name = "post_comment")
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native", strategy = "native")
    int id;

    @Column(name = "parentId")
    int parentId;
    @Column(name = "title")
    String title;
    @Column(name = "published")
    int published;
    @Column(name = "publishedAt")
    LocalDateTime publishedAt;

    @Column(name = "createdAt")
    LocalDateTime createdAt;

    @Column(name="content")
    String content;



}
