package com.luxcampus.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class PostDTO {

    Integer postId;
    String title;
    String content;
    Boolean star;
    List<Integer> comments;
}
