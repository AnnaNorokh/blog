package com.luxcampus.blog;

import com.luxcampus.blog.repository.BlogRepository;
import com.luxcampus.blog.service.BlogServiceImpl;
import com.luxcampus.blog.web.BlogController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest(BlogController.class)
public class BlogControllerTest {


    private BlogServiceImpl blogServiceImpl;

    private BlogRepository blogRepository;

    @Test
    void getAllPostsTest (){

    }

    @Test
    void findPostByIdTest (){

    }

    @Test
    void addPostTest (){

    }

    @Test
    void editPostByIdTest (){

    }

    @Test
    void deletePostByIdTest () {

    }



}
