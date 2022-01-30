package com.luxcampus.blog.service;

import com.luxcampus.blog.entity.Post;
import com.luxcampus.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private final BlogRepository blogRepository;

    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public List<Post> getAllPosts(){
        return blogRepository.findAll();
    }

    @Override
    public Post findPostById(Integer id){
        return blogRepository.findById(id).get();
    }

    @Override
    public  List<Post> findPostsByTitle(String title){
        return blogRepository.findPostsByTitle(title);
    }

    @Override
    public void addPost (Post post){
        blogRepository.save(post);
    }

    @Override
    public void editPostById (Integer id, Post post){
        if(!blogRepository.existsById(id)){
            throw new IllegalStateException();
        }
        Post newPost = blogRepository.findById(id).get();

        newPost.setTitle(post.getTitle());
        newPost.setContent(post.getContent());

        blogRepository.save(newPost);
    }

    @Override
    public void deletePostById (Integer id){
        boolean exist = blogRepository.existsById(id);
        if(!exist){
            throw new IllegalStateException();
        }
        blogRepository.deleteById(id);
    }

}

