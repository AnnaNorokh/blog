package com.luxcampus.blog.service;

import com.luxcampus.blog.dto.CommentDTO;
import com.luxcampus.blog.entity.Comment;

import java.util.List;

public interface CommentService {

    void addComment(CommentDTO comment);

    CommentDTO getCommentById(Integer commentId);

    List<CommentDTO> getCommentsByPostId(Integer postId);

    CommentDTO getCommentByPostId(Integer postId, Integer commentId);

    List<CommentDTO> getAllComments();
}
