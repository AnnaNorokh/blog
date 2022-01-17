package com.luxcampus.blog.repository;

import com.luxcampus.blog.entity.Post;

import java.util.List;

public interface BlogRepository {

    List<Post> findAll();

    void add(Post post);

    void edit(Post post);

    void delete(int id);

}
