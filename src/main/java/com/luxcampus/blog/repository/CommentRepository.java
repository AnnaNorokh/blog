package com.luxcampus.blog.repository;

import com.luxcampus.blog.dto.CommentDTO;
import com.luxcampus.blog.entity.Comment;
import com.luxcampus.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> getCommentsByPostId(Integer postId);


}
