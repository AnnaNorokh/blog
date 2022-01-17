package com.luxcampus.blog.service;

import com.luxcampus.blog.entity.Post;
import com.luxcampus.blog.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public List<Post> findAll(){

        return blogRepository.findAll();
    }

    public void add (Post post){
        blogRepository.add(post);
    }

    public void edit (Post post){
        blogRepository.edit(post);
    }

    public void delete (int id){
        blogRepository.delete(id);
    }
}
