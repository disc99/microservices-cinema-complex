package io.disc99;

import io.disc99.archetype.CommandBus;
import io.disc99.archetype.EventBus;
import io.disc99.archetype.EventStore;
import io.disc99.archetype.impl.EventBusInMemory;
import io.disc99.archetype.impl.EventStoreInMemory;
import io.disc99.todo.application.DoHandler;
import io.disc99.todo.application.ModifyHandler;
import io.disc99.todo.application.TodoService;
import io.disc99.todo.domain.AddedHandler;
import io.disc99.todo.domain.TodoRepository;
import io.disc99.todo.infrastructure.TodoRepositoryInMemory;
import io.disc99.todo.query.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class TodoConfig {

    @Bean
    EventStore eventStore() {
        return new EventStoreInMemory();
    }

    @Bean
    TodoRepository todoRepository(EventStore eventStore) {
        return new TodoRepositoryInMemory(eventStore);
    }

    @Bean
    CommandBus commandBus(TodoRepository todoRepository) {
        CommandBus commandBus = new CommandBus();
        commandBus.register(new ModifyHandler(todoRepository));
        commandBus.register(new DoHandler(todoRepository));
        return commandBus;
    }

    @Bean
    NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    EventBus eventBus(EventStore eventStore, NamedParameterJdbcTemplate jdbcTemplate) {
        EventBus eventBus = new EventBusInMemory();
        eventBus.subscribe(new AddedHandler(eventStore));
        eventBus.subscribe(new AddedProjection(jdbcTemplate));
        eventBus.subscribe(new ModifiedProjection(jdbcTemplate));
        eventBus.subscribe(new DoneProjection(jdbcTemplate));
        return eventBus;
    }

    @Bean
    TodoService todoService(CommandBus commandBus, EventBus eventBus) {
        return new TodoService(commandBus, eventBus);
    }

    @Bean
    TodoQueryService todoQueryService(NamedParameterJdbcTemplate jdbcTemplate) {
        return new TodoQueryService(jdbcTemplate);
    }
}
