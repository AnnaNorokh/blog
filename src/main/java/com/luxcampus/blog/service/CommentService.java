package com.luxcampus.blog.service;

import com.luxcampus.blog.entity.Comment;
import com.luxcampus.blog.entity.Post;

import java.util.List;

public interface CommentService {

    void addComment(Comment comment);

    Comment getCommentById(Integer commentId);

    List<Comment> getCommentsByPostId(Integer postId);
}
