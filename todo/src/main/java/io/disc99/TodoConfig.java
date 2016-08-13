package io.disc99;

import io.disc99.archetype.CommandBus;
import io.disc99.archetype.EventBus;
import io.disc99.todo.application.DoHandler;
import io.disc99.todo.application.ModifyHandler;
import io.disc99.todo.application.TodoService;
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

    @Bean
    CommandBus commandBus(TodoRepository todoRepository) {
        CommandBus commandBus = new CommandBus();
        commandBus.register(new ModifyHandler(todoRepository));
        commandBus.register(new DoHandler(todoRepository));
        return commandBus;
    }

    @Bean
    EventBus eventBus() {
        return new EventBus();
    }

    @Bean
    TodoService todoService(CommandBus commandBus, EventBus eventBus) {
        return new TodoService(commandBus, eventBus);
    }
}
