package io.disc99.todo.domain;

import io.disc99.archetype.*;
import io.disc99.ObjectProvider;
import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;

import java.util.List;

@Value
@Accessors(fluent = true)
public class Todo implements Entity {

    private final EventBus eventBus = ObjectProvider.provide(EventBus.class);

    TodoId todoId;
    Doing doing;
    DoneAt doneAt;

    public Todo(List<DomainEvent> domainEvents) {
        // TODO
        this.todoId = null;
        this.doing = null;
        this.doneAt = null;
    }

    public void modified(Doing doing) {
        Modified modified = new Modified(todoId, doing);
        eventBus.apply(modified);
    }

    public void done() {
        Done done = new Done(todoId);
        eventBus.apply(done);
    }
}
