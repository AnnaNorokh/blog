package com.luxcampus.blog.repository;

import com.luxcampus.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlogRepository extends JpaRepository<Post, Integer> {

	List<Post> findPostsByTitle(String title);

	List<Post> getPostsSortedByTitle(String title);
}
