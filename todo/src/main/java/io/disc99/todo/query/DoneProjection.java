package io.disc99.todo.query;

import io.disc99.archetype.EventHandler;
import io.disc99.todo.domain.Done;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@AllArgsConstructor
public class DoneProjection implements EventHandler<Done> {

    NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void on(Done event) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", event.todoId().value())
                .addValue("status", Status.DONE)
                ;
        jdbcTemplate.update("UPDATE TODOS SET STATUS = :status WHERE ID = :id", params);
    }
}
