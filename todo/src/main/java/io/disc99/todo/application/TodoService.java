package io.disc99.todo.application;

import io.disc99.archetype.CommandBus;
import io.disc99.todo.domain.TodoList;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TodoService {

    private CommandBus commandBus;

    public TodoList create() {
        return new TodoList();
    }

    public void add(Add add) {
        commandBus.dispatch(add);
    }

}
