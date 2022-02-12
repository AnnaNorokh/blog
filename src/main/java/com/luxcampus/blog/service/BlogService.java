package com.luxcampus.blog.service;

import com.luxcampus.blog.entity.Comment;
import com.luxcampus.blog.entity.Post;

import java.util.List;

public interface BlogService {

	List<Post> getAllPosts();

	Post findPostById(Integer id);

	List<Post> findPostsByTitle(String title);

	List<Post> getPostsSortedByTitle(String title);

	void addPost(Post post);

	void editPostById(Integer id, Post post);

	void deletePostById(Integer id);

	void addStar(Integer id);

	void removeStar(Integer id);

	List<Post> getAllStarPosts();

}
