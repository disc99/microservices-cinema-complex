package io.disc99;

import io.disc99.archetype.CommandBus;
import io.disc99.todo.application.ModifyHandler;
import io.disc99.todo.domain.TodoRepository;
import io.disc99.todo.infrastructure.TodoRepositoryInMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TodoConfig {

    @Bean
    TodoRepository todoRepository() {
        return new TodoRepositoryInMemory();
    }
}
