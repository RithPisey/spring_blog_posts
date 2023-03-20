package com.java.blogposts.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.apachecommons.CommonsLog;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "category")
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
    @JsonIgnore
    Set<Post> posts;
}
