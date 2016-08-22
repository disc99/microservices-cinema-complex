package io.disc99.todo.application;

import io.disc99.archetype.CommandBus;
import io.disc99.archetype.EventBus;
import io.disc99.archetype.EventHandler;
import io.disc99.todo.domain.Added;
import io.disc99.todo.domain.Doing;
import io.disc99.todo.domain.TodoId;
import io.disc99.todo.domain.TodoList;
import lombok.AllArgsConstructor;

import java.util.function.ToIntBiFunction;

@AllArgsConstructor
public class TodoService {

    private CommandBus commandBus;
    private EventBus eventBus;

    public TodoId add(Add add) {
        TodoId todoId = new TodoId();
//        commandBus.dispatch(add);
        new TodoList().add(todoId,new Doing(add.doing()));
        return todoId;
    }

    public void modify(Modify modify) {
        commandBus.dispatch(modify);
    }

    public void doit(Do aDo) {
        commandBus.dispatch(aDo);
    }
}
