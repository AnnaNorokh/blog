package com.luxcampus.blog.dto;

import com.luxcampus.blog.entity.Comment;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Builder
@Data
public class PostWithComments {

    private Integer id;
    private String title;
    private String content;
    private boolean star;
    List<Comment> comments;
}
