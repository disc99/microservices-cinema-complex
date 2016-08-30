package io.disc99.todo.application;

import io.disc99.archetype.CommandHandler;
import io.disc99.todo.domain.Doing;
import io.disc99.todo.domain.Todo;
import io.disc99.todo.domain.TodoId;
import io.disc99.todo.domain.TodoRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ModifyHandler implements CommandHandler<Modify> {

    private TodoRepository todoRepository;

    @Override
    public void handle(Modify command) {
        Todo todo = todoRepository.findById(new TodoId(command.identify()));
        todo.modified(new Doing(command.doing()));
    }
}
