package com.luxcampus.blog;

import com.luxcampus.blog.entity.Post;
import com.luxcampus.blog.service.BlogServiceImpl;
import com.luxcampus.blog.web.BlogController;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(BlogController.class)
public class BlogServiceTest {

    @MockBean
    private BlogServiceImpl blogServiceImpl;

    @Autowired
    private MockMvc mockMvc;

    private Post post;

    @BeforeEach
    void createTestPost() {
        post = Post.builder()
                .id(1)
                .title("cat")
                .content("meow meow meow")
                .star(false)
                .build();
    }

    @Test
    public void getAllPostsTest () throws Exception {
        when(blogServiceImpl.getAllPosts())
                .thenReturn(List.of(post));

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/blog/posts")
                        .header("MEOW", "Cat"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].title").value("cat"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].content").value("meow meow meow"));
    }

    @Test
    public void findPostByIdTest () throws Exception {
        when(blogServiceImpl.findPostById(1))
                .thenReturn(post);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/blog/posts/1")
                        .header("Id", "1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
    }

    @Test
    public void findPostsByTitle() throws Exception {
        when(blogServiceImpl.findPostsByTitle("cat"))
                .thenReturn(List.of(post));

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/blog/posts?title=cat")
                        .header("Title", "Cat"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].title").value("cat"));
    }

    @Test
    public void addPostTest () throws Exception {
        doNothing().when(blogServiceImpl).addPost(post);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/blog/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\": \"frog\",\"content\": \"Kwak kwak\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @Test
    public void editPostByIdTest () throws Exception {
        doNothing().when(blogServiceImpl).editPostById(1,post);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/blog/posts/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\": \"frog\",\"content\": \"Kwak kwak\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @Test
    public void deletePostByIdTest () throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .delete("/blog/posts/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(blogServiceImpl).deletePostById(1);
    }
}
