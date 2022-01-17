package com.luxcampus.blog.web;

import com.luxcampus.blog.entity.Post;
import com.luxcampus.blog.service.BlogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/posts")
@RequiredArgsConstructor
@Slf4j
public class BlogController {

    Logger logger = LoggerFactory.getLogger(getClass());

    private final BlogService blogService;

    @GetMapping
    public List<Post> findAll(){
        List<Post> posts = blogService.findAll();

        logger.info("posts {}", posts);

        return posts;
    }

    @PostMapping
    public void addPost(@RequestBody Post post){
        logger.info("posts add{}", post);
        blogService.add(post);
    }
}
