package com.luxcampus.blog.web;

import com.luxcampus.blog.entity.Comment;
import com.luxcampus.blog.entity.Post;
import com.luxcampus.blog.service.BlogServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/blog/posts")
@Slf4j
public class BlogController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BlogServiceImpl blogServiceImpl;

    @GetMapping
    public List<Post> getAllPosts(){
        return blogServiceImpl.getAllPosts();
    }

    @GetMapping(path = "/{id}")
    public Post findPostById(@PathVariable("id") Integer id){
        return blogServiceImpl.findPostById(id);
    }

    @GetMapping(params = {"title"})
    public  List<Post> findPostByTitle(@RequestParam("title") String title){
        return blogServiceImpl.findPostsByTitle(title);
    }

    @GetMapping(params = {"sort"})
    public List<Post> getPostsSortedByTitle(@RequestParam(value = "sort", required = false) String title){
        return blogServiceImpl.getPostsSortedByTitle(title);
    }

    @PostMapping
    public void addPost(@RequestBody Post post){
        blogServiceImpl.addPost(post);
    }

    @PutMapping(path = "/{id}")
    public void editPostById(@PathVariable("id") Integer id,
                             @RequestBody Post post){
        blogServiceImpl.editPostById(id, post);
    }

    @DeleteMapping(path = "/{id}")
    public void deletePostById(@PathVariable("id") Integer id){
        blogServiceImpl.deletePostById(id);
    }

    @GetMapping(path = "/star")
    public List<Post> getAllStarPosts(){
        return blogServiceImpl.getAllStarPosts();
    }

    @PutMapping(path = "/star/{id}")
    public void addStar(@PathVariable("id") Integer id){
        blogServiceImpl.addStar(id);
    }

    @DeleteMapping(path = "/star/{id}")
    public void removeStar(@PathVariable("id") Integer id){
        blogServiceImpl.removeStar(id);
    }

    @PostMapping
    public void addComment(@RequestBody Comment comment){
        blogServiceImpl.addComment(comment);
    }

    @GetMapping(path = "/{commentId}/comments")
    public Post getCommentById(@PathVariable("commentId") Integer commentId){
        return blogServiceImpl.getCommentById(commentId);
    }

    @GetMapping(params = "{postId}/comments/{commentId}")
    public  List<Post> getCommentByPostId(@PathVariable("postId") Integer postId, @PathVariable("commentId") Integer commentId){
        return blogServiceImpl.getCommentsByPostId(postId);
    }

}


