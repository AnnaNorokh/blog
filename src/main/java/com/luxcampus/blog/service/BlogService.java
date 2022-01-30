package com.luxcampus.blog.service;

import com.luxcampus.blog.entity.Post;

import java.util.List;

public interface BlogService {

	List<Post> getAllPosts();

	Post findPostById(Integer id);

	List<Post> findPostsByTitle(String title);

	void addPost(Post post);

	void editPostById(Integer id, Post post);

	void deletePostById(Integer id);

}
