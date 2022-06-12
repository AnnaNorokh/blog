package com.luxcampus.blog.service;

import com.luxcampus.blog.dto.CommentDTO;
import com.luxcampus.blog.dto.mappers.CommentMapper;
import com.luxcampus.blog.entity.Comment;
import com.luxcampus.blog.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private final CommentRepository commentRepository;
    @Autowired
    private final  CommentMapper commentMapper;

    public CommentServiceImpl(CommentRepository commentRepository, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }

    @Override
    public void addComment(CommentDTO comment){
        commentRepository.save(commentMapper.CommentDTOtoComment(comment));
    }


    @Override
    public CommentDTO getCommentById(Integer commentId){
        return commentMapper.CommentToCommentDTO(commentRepository.findById(commentId).get());
    }

    @Override
    public List<CommentDTO> getCommentsByPostId(Integer postId){
        List<Comment> comments = commentRepository.findAll();
        List<CommentDTO> commentDTOS = new ArrayList<>();
        for(int i = 0; i<comments.size() - 1; i++){
            commentDTOS.add(commentMapper.CommentToCommentDTO(comments.get(i)));
        }

        return commentDTOS;
    }

    @Override
    public List<CommentDTO> getAllComments(){
        List<Comment> comments = commentRepository.findAll();
        List<CommentDTO> commentDTOS = new ArrayList<>();

        for(int i=0; i<comments.size(); i++){
            commentDTOS.add(commentMapper.CommentToCommentDTO(comments.get(i)));
        }
       return commentDTOS;
    }

}
