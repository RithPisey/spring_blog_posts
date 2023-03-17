package com.java.blogposts.model;

import jakarta.persistence.*;
import lombok.extern.apachecommons.CommonsLog;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native", strategy = "native")
    int id;

    @Column(name = "parentId")
    String parentId;
    @Column(name = "title")
    String title;
    @Column(name="metaTitle")
    String metaTitle;
    @Column(name = "slug")
    String slug;
    @Column(name="content")
    String content;

    @ManyToMany(mappedBy = "categories")
    Set<Post> posts = new HashSet<>();
}
