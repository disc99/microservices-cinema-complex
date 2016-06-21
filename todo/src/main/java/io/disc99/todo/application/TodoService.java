package io.disc99.todo.application;

import io.disc99.archetype.CommandBus;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TodoService {

    private CommandBus commandBus;

    public void add(Add add) {
        commandBus.dispatch(add);
    }

}
