package com.luxcampus.blog.service;

import com.luxcampus.blog.dto.PostDTO;
import com.luxcampus.blog.entity.Post;

import java.util.List;

public interface BlogService {

	List<PostDTO> getAllPosts();

	PostDTO findPostById(Integer id);

	List<Post> findPostsByTitle(String title);

	List<Post> getPostsSortedByTitle(String title);

	void addPost(PostDTO post);

	void editPostById(Integer id, PostDTO post);

	void deletePostById(Integer id);

	void addStar(Integer id);

	void removeStar(Integer id);

	List<PostDTO> getAllStarPosts();

}
