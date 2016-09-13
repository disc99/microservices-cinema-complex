package io.disc99.todo.query;

import io.disc99.archetype.EventHandler;
import io.disc99.todo.domain.Added;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

@AllArgsConstructor
public class AddedProjection implements EventHandler<Added> {

    JdbcTemplate jdbcTemplate;

    @Override
    public void on(Added event) {
        jdbcTemplate.update(
                "insert into todos(id, doing) values("
                + event.todoId().value()
                + ", "
                + event.doing().value()
                + ")"
        );
    }
}
