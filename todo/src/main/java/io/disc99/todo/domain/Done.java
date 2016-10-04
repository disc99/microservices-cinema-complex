package io.disc99.todo.domain;

import io.disc99.archetype.DomainEvent;
import io.disc99.archetype.Identify;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;
import lombok.experimental.Accessors;

@Value
@Accessors(fluent = true)
public class Done implements DomainEvent {
    TodoId todoId;
    DoneAt doneAt;
    public Done(TodoId todoId) {
        this.todoId = todoId;
        this.doneAt = null;
    }
}
