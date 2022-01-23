package com.luxcampus.blog.service;

import com.luxcampus.blog.entity.Post;

import java.util.List;

public interface BlogService {

    public List<Post> getAllPosts();

    public Post findPostById(Integer id);

    public void addPost(Post post);

    public void editPostById(Integer id, Post post);

    public void deletePostById(Integer id);

}
