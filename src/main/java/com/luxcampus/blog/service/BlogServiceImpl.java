package com.luxcampus.blog.service;

import com.luxcampus.blog.dto.PostDTO;
import com.luxcampus.blog.dto.mappers.PostMapper;
import com.luxcampus.blog.entity.Post;
import com.luxcampus.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private final BlogRepository blogRepository;

    @Autowired
    private final PostMapper postMapper;

    public BlogServiceImpl(BlogRepository blogRepository, PostMapper postMapper) {
        this.blogRepository = blogRepository;
        this.postMapper = postMapper;
    }

    @Override
    public List<PostDTO> getAllPosts(){
        ArrayList<PostDTO> postDTO = new ArrayList<>();
        List<Post> posts = blogRepository.findAll();

        for(int i=0; i<posts.size(); i++){
            postDTO.add(postMapper.PostToPostDTO(posts.get(i)));
        }

        return postDTO;
    }

    @Override
    public PostDTO findPostById(Integer id){
        return postMapper.PostToPostDTO(blogRepository.findById(id).get());
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
    public void addPost (PostDTO post){
        blogRepository.save(postMapper.PostDTOToPost(post));
    }

    @Override
    public void editPostById (Integer id, PostDTO post){
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
    public List<PostDTO> getAllStarPosts(){
        List<Post> posts = blogRepository.findAll();
        List<PostDTO> starPosts = new ArrayList<>();

        for (Post post : posts) {
            if (post.isStar()) {
                starPosts.add(postMapper.PostToPostDTO(post));
            }
        }

       return starPosts;
    }




}

