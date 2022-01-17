package com.luxcampus.blog.repository.JDBC;

import com.luxcampus.blog.entity.Post;
import com.luxcampus.blog.repository.BlogRepository;
import com.luxcampus.blog.repository.mapper.BlogRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class JdbcBlogRepository implements BlogRepository {
    private static final BlogRowMapper BLOG_ROW_MAPPER = new BlogRowMapper();
    private static final String FIND_ALL_SQL = "SELECT id, title, content FROM posts";

    private static final String ADD_SQL = "INSERT INTO posts (id, title, content) " +
            "VALUES (:id, :title, :content)";

    private static final String EDIT_POST_SQL = "UPDATE posts" +
            "SET title = :title, content = :content " +
            "WHERE id = :id";

    private static final String DELETE_POST_SQL = "DELETE FROM posts\n" +
            "WHERE id = :id ";

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Post> findAll(){
        return jdbcTemplate.query(FIND_ALL_SQL,BLOG_ROW_MAPPER);
    }

    @Override
    public void add(Post post) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", post.getId());
        parameters.put("title", post.getTitle());
        parameters.put("content", post.getContent());

        namedParameterJdbcTemplate.update(ADD_SQL, parameters);
    }

    @Override
    public void edit(Post post) {

    }

    @Override
    public void delete(int id){
        //namedParameterJdbcTemplate.update(DELETE_POST_SQL, id);
    }

}
