package com.java.blogposts.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native", strategy = "native")
    private int id;
    private String title;
    private String metaTitle;
    private String slug;
    private String summary;
    private int published;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime publishedAt;
    private  String content;

    @ManyToMany
    @JoinTable(name="post_category",joinColumns = @JoinColumn(name = "postId"), inverseJoinColumns = @JoinColumn(name = "categoryId"))
    private Set<Category> categories = new HashSet<>();

}
