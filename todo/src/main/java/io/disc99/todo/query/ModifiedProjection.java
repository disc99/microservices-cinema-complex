package io.disc99.todo.query;

import io.disc99.archetype.EventHandler;
import io.disc99.todo.domain.Modified;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@AllArgsConstructor
public class ModifiedProjection implements EventHandler<Modified> {

    NamedParameterJdbcTemplate  namedParameterJdbcTemplate;

    @Override
    public void on(Modified event) {

    }
}
