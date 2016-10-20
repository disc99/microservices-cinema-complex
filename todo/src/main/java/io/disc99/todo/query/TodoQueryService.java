package io.disc99.todo.query;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

@AllArgsConstructor
public class TodoQueryService {

    NamedParameterJdbcTemplate jdbcTemplate;

    public TodoDto findById(String id) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", id);
        return jdbcTemplate.queryForObject("SELECT * FROM TODOS WHERE ID = :id",
                params, new BeanPropertyRowMapper<>(TodoDto.class));
    }

    public List<TodoDto> findAll() {
        return jdbcTemplate.query("SELECT * FROM TODOS", new BeanPropertyRowMapper<>(TodoDto.class));
    }
}
