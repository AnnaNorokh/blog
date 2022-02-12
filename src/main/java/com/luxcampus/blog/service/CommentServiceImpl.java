package com.luxcampus.blog.service;

import com.luxcampus.blog.entity.Comment;
import com.luxcampus.blog.entity.Post;
import com.luxcampus.blog.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void addComment(Comment comment){
        commentRepository.save(comment);
    }

    @Override
    public Comment getCommentById(Integer commentId){
        return commentRepository.findById(commentId).get();
    }

    @Override
    public List<Comment> getCommentsByPostId(Integer postId){
        List<Comment> comments = commentRepository.findAll();


        return comments;
    }

}
