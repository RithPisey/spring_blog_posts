package com.java.blogposts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.java.blogposts.*")

public class BlogpostsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogpostsApplication.class, args);
	}

}
