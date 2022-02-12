package com.luxcampus.blog.web;

import com.luxcampus.blog.entity.Comment;
import com.luxcampus.blog.entity.Post;
import com.luxcampus.blog.service.BlogServiceImpl;
import com.luxcampus.blog.service.CommentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/blog/comments")
@Slf4j
public class CommentController {

    @Autowired
    private CommentServiceImpl commentServiceImpl;

    @PostMapping
    public void addComment(@RequestBody Comment comment){
        commentServiceImpl.addComment(comment);
}

    @GetMapping(path = "/{commentId}/comments")
    public Comment getCommentById(@PathVariable("commentId") Integer commentId){
        return commentServiceImpl.getCommentById(commentId);
    }

    @GetMapping(params = "{postId}/comments/{commentId}")
    public List<Comment> getCommentByPostId(@PathVariable("postId") Integer postId,
                                            @PathVariable("commentId") Integer commentId){
        return commentServiceImpl.getCommentsByPostId(postId);
    }
}
