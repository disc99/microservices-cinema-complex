package io.disc99.todo.query;

import io.disc99.archetype.EventHandler;
import io.disc99.todo.domain.Modified;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@AllArgsConstructor
public class ModifiedProjection implements EventHandler<Modified> {

    NamedParameterJdbcTemplate  jdbcTemplate;

    @Override
    public void on(Modified event) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", event.todoId().value())
                .addValue("doing", event.doing().value());
        jdbcTemplate.update("UPDATE TODOS SET DOING = :doing WHERE ID = :id", params);
    }
}
