package io.disc99.todo.infrastructure;

import io.disc99.archetype.EventStore;
import io.disc99.archetype.EventStream;
import io.disc99.todo.domain.Todo;
import io.disc99.todo.domain.TodoId;
import io.disc99.todo.domain.TodoRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TodoRepositoryInMemory implements TodoRepository {

    private EventStore eventStore;

    @Override
    public Todo findById(TodoId todoId) {
        EventStream stream = eventStore.stream(Todo.class, todoId);
        return new Todo(stream.events());
    }
}
