package io.disc99.todo.application;

import io.disc99.archetype.CommandHandler;
import io.disc99.todo.domain.Todo;
import io.disc99.todo.domain.TodoRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DoHandler implements CommandHandler<Do> {

    private TodoRepository todoRepository;

    @Override
    public void handle(Do command) {
        Todo todo = todoRepository.find(command.identify());
        todo.done();
    }
}
