package com.java.blogposts.model;

import com.java.blogposts.composite_key.PostCategoryKey;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity()

@Table(name = "post_category")
public class PostCategory {


    @EmbeddedId
    PostCategoryKey id;

    @ManyToOne
    @MapsId("postId")
    @JoinColumn(name="postId")
    private Post post;

    @ManyToOne
    @MapsId("categoryId")
    @JoinColumn(name="categoryId")
    private Category category;
}
