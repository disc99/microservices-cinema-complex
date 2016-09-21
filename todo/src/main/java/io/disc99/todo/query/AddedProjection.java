package io.disc99.todo.query;

import io.disc99.archetype.EventHandler;
import io.disc99.todo.domain.Added;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@AllArgsConstructor
public class AddedProjection implements EventHandler<Added> {

    NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void on(Added event) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", event.todoId().value())
                .addValue("doing", event.doing().value())
                .addValue("status", Status.NOT_DONE)
                ;
        jdbcTemplate.update("INSERT INTO TODOS(ID, DOING, STATUS) VALUES(:id, :doing, :status)", params);
    }
}
