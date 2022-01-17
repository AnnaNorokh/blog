package com.luxcampus.blog.service;

import com.luxcampus.blog.entity.Post;

import java.util.List;

public interface Service {

    List<Post> findAll();

    void add(Post post);

    void edit(Post post);

    void delete(int id);
}
