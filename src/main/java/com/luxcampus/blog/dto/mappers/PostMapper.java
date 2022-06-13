package com.luxcampus.blog.dto.mappers;

import com.luxcampus.blog.dto.FullPostDTO;
import com.luxcampus.blog.dto.PostDTO;
import com.luxcampus.blog.entity.Comment;
import com.luxcampus.blog.entity.Post;
import com.luxcampus.blog.repository.CommentRepository;
import com.luxcampus.blog.service.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class PostMapper {
    @Autowired
    CommentRepository commentRepository;

    @Autowired
    CommentServiceImpl commentService;

    public PostDTO PostToPostDTO(Post post){
        PostDTO postDTO = new PostDTO();
        ArrayList<Integer> comments = new ArrayList<>();
        postDTO.setPostId(post.getId());
        postDTO.setTitle(post.getTitle());
        postDTO.setContent(post.getContent());
        postDTO.setStar(post.isStar());
        for(int i = 0; i < post.getComments().size(); i++){
            comments.add(post.getComments().get(i).getCommentId());
        }
        postDTO.setComments(comments);

        return postDTO;
    }

    public Post PostDTOToPost(PostDTO postDTO){
        Post post = new Post();
        post.setId(postDTO.getPostId());
        post.setStar(postDTO.getStar());
        post.setContent(postDTO.getContent());
        post.setTitle(postDTO.getTitle());
        if(postDTO.getComments() != null) {
            post.setComments(commentRepository.getCommentsByPostId(postDTO.getPostId()));
        }

        return post;
    }

    public FullPostDTO PostToFullPostDTO(Post post) {
        FullPostDTO fullPostDTO = new FullPostDTO();
        fullPostDTO.setPostId(post.getId());
        fullPostDTO.setTitle(post.getTitle());
        fullPostDTO.setContent(post.getContent());
        fullPostDTO.setStar(post.isStar());
        if(post.getComments() != null) {
            fullPostDTO.setComments(commentService.getCommentsByPostId(post.getId()));
        }

        return fullPostDTO;
    }
}
