package com.java.blogposts.composite_key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;


@Embeddable
@Getter
@Setter
public class PostCategoryKey implements Serializable {
    @Column(name = "postId")
    Long postId;
    @Column(name = "categoryId")
    Long categoryId;


}
