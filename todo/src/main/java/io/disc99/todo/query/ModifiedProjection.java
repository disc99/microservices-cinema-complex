package io.disc99.todo.query;

import io.disc99.archetype.EventHandler;
import io.disc99.todo.domain.Modified;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

@AllArgsConstructor
public class ModifiedProjection implements EventHandler<Modified> {

    JdbcTemplate jdbcTemplate;

    @Override
    public void on(Modified event) {

    }
}
