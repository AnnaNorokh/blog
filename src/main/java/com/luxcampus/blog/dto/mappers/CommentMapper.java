package com.luxcampus.blog.dto.mappers;

import com.luxcampus.blog.dto.CommentDTO;
import com.luxcampus.blog.entity.Comment;
import com.luxcampus.blog.repository.BlogRepository;
import com.luxcampus.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {
    @Autowired
    BlogService blogService;
    @Autowired
    BlogRepository blogRepository;

    public Comment CommentDTOtoComment(CommentDTO commentDTO){
        Comment comment = new Comment();
        comment.setPost(blogRepository.getById(commentDTO.getPost()));
        comment.setText(commentDTO.getText());
        return comment;
    }

    public CommentDTO CommentToCommentDTO(Comment comment){
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setPost(comment.getPost().getId());
        commentDTO.setCommentId(comment.getCommentId());
        commentDTO.setCreationDate(comment.getCreationDate());
        commentDTO.setText(comment.getText());
        return commentDTO;
    }
}
