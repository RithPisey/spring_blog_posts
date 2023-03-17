package com.java.blogposts.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class PostMeta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native", strategy = "native")
    int id;

    @Column(name = "key")
    String key;
    @Column(name = "content")
    String content;

}
