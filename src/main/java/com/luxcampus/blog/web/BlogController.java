package com.luxcampus.blog.web;

import com.luxcampus.blog.entity.Post;
import com.luxcampus.blog.service.BlogServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/blog")
@Slf4j
public class BlogController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BlogServiceImpl blogServiceImpl;

    @GetMapping("/posts")
    public List<Post> getAllPosts(){
        List<Post> posts = blogServiceImpl.getAllPosts();
        return posts;
    }

    @GetMapping(path = "/posts/{id}")
    public Post findPostById(@PathVariable("id") Integer id){
        return blogServiceImpl.findPostById(id);
    }

    @PostMapping
    public void addPost(@RequestBody Post post){
        logger.info("Posted");
        blogServiceImpl.addPost(post);
    }

    @PutMapping(path = "/posts/{id}")
    public void editPostById(@PathVariable("id") Integer id,
                             @RequestBody Post post){
        blogServiceImpl.editPostById(id, post);
    }

    @DeleteMapping(path = "/posts/{id}")
    public void deletePostById(@PathVariable("id") Integer id){
        logger.info("Deleted");
        blogServiceImpl.deletePostById(id);
    }


}


