package com.java.blogposts.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native", strategy = "native")
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "metaTitle")
    private String metaTitle;
    @Column(name = "slug")
    private String slug;
    @Column(name = "summary")
    private String summary;
    @Column(name = "published")
    private int published;
    @Column(name = "createdAt")
    private LocalDateTime createdAt;
    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;
    @Column(name = "publishedAt")
    private LocalDateTime publishedAt;
    @Column(name = "content")
    private  String content;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="post_category",joinColumns = @JoinColumn(name = "postId"), inverseJoinColumns = @JoinColumn(name = "categoryId"))
    private Set<Category> categories;

}
