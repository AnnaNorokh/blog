package com.luxcampus.blog.dto.mappers;

import com.luxcampus.blog.dto.PostDTO;
import com.luxcampus.blog.entity.Comment;
import com.luxcampus.blog.entity.Post;
import com.luxcampus.blog.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class PostMapper {
    @Autowired
    CommentRepository commentRepository;

    public PostDTO PostToPostDTO(Post post){
        PostDTO postDTO = new PostDTO();
        ArrayList<Integer> comments = new ArrayList<>();
        postDTO.setPostId(post.getId());
        postDTO.setContent(post.getContent());
        postDTO.setStar(post.isStar());
        postDTO.setTitle(post.getTitle());
        for(int i=0; i<post.getComments().size(); i++){
            comments.add(post.getComments().get(i).getCommentId());
        }
        postDTO.setComments(comments);
        return postDTO;
    }

    public Post PostDTOToPost(PostDTO postDTO){
        List<Comment> comments = new ArrayList<>();
        Post post = new Post();
        post.setStar(postDTO.getStar());
        post.setContent(postDTO.getContent());
        post.setTitle(postDTO.getTitle());
        if(postDTO.getComments()!=null) {
            for (int i = 0; i < postDTO.getComments().size(); i++) {
                comments.add(commentRepository.getCommentByPostId(postDTO.getPostId()).get(i));
            }

            post.setComments(comments);
        }
        return post;
    }
}
