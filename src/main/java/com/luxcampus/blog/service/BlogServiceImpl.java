package com.luxcampus.blog.service;

import com.luxcampus.blog.entity.Comment;
import com.luxcampus.blog.entity.Post;
import com.luxcampus.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
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
    public List<Post> getPostsSortedByTitle(String title){
        return blogRepository.findAll(Sort.by(Sort.Direction.ASC, title));
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

    @Override
    public void addStar(Integer id){
        Post newPost = blogRepository.findById(id).get();
        newPost.setStar(true);

        blogRepository.save(newPost);
    }

    @Override
    public void removeStar(Integer id){
        Post newPost = blogRepository.findById(id).get();
        newPost.setStar(false);

        blogRepository.save(newPost);
    }

    @Override
    public  List<Post> getAllStarPosts(){
        List<Post> posts = blogRepository.findAll();
        List<Post> starPosts = new LinkedList<>();

        for (int i = 0; i < posts.size(); i++) {
            Post post = posts.get(i);
            if(post.isStar()){
                starPosts.add(post);
            }
        }

       return starPosts;
    }




}

