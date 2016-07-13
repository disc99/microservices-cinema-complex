package io.disc99.todo.application;

import io.disc99.archetype.CommandHandler;
import io.disc99.todo.domain.Added;
import io.disc99.todo.domain.TodoList;
import io.disc99.todo.domain.TodoRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AddHandler implements CommandHandler<Add> {

    private TodoRepository todoRepository;

    @Override
    public void handle(Add add) {
        new TodoList().add(new Added(add.identify(), add.doing()));
    }
}
