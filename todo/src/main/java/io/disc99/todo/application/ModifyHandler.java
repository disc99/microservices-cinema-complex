package io.disc99.todo.application;

import io.disc99.archetype.CommandHandler;
import io.disc99.todo.domain.Todo;
import io.disc99.todo.domain.TodoRepository;

public class ModifyHandler implements CommandHandler<Modify> {
    private TodoRepository todoRepository;

    @Override
    public void handle(Modify command) {
        Todo todo = todoRepository.find(command.identify());
        todo.modified(command.doing());
    }
}
