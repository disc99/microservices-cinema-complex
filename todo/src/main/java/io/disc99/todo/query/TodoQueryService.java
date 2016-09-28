package io.disc99.todo.query;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

@AllArgsConstructor
public class TodoQueryService {

    NamedParameterJdbcTemplate jdbcTemplate;

    public TodoDto findById(String id) {
        // TODO
        return null;
    }

    public List<TodoDto> findAll() {
        // TOOD
        return null;
    }
}
