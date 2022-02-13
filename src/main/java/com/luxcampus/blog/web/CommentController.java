package com.luxcampus.blog.web;

import com.luxcampus.blog.dto.CommentDTO;
import com.luxcampus.blog.dto.mappers.CommentMapper;
import com.luxcampus.blog.entity.Comment;
import com.luxcampus.blog.service.CommentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/blog/posts")
@Slf4j
public class CommentController {
    @Autowired
    CommentMapper commentMapper;

    @Autowired
    private CommentServiceImpl commentServiceImpl;

    @PostMapping(path = "/comments")
    public void addComment(@RequestBody CommentDTO comment){
        commentServiceImpl.addComment(comment);
}

    @GetMapping(path = "/{commentId}/comments")
    public CommentDTO getCommentById(@PathVariable("commentId") Integer commentId){
        return commentServiceImpl.getCommentById(commentId);
    }

    @GetMapping(path = "/comments")
    public List<CommentDTO> getComments(){
        return commentServiceImpl.getAllComments();
    }

    @GetMapping(params = "{postId}/comments/{commentId}")
    public List<CommentDTO> getCommentByPostId(@PathVariable("postId") Integer postId,
                                            @PathVariable("commentId") Integer commentId){
        return commentServiceImpl.getCommentsByPostId(postId);
    }
}
