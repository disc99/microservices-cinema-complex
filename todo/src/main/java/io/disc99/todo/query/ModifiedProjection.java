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
                .addValue("ID", event.todoId().value())
                .addValue("DOING", event.doing().value());
        jdbcTemplate.update("INSERT INTO TODOS(ID, DOING) VALUES(:id, :doing)", params);

    }
}
