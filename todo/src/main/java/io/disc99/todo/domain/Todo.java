package io.disc99.todo.domain;

import io.disc99.archetype.*;
import io.disc99.ObjectProvider;
import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;

import java.util.List;

@AllArgsConstructor
@Accessors(fluent = true)
public class Todo implements Entity {

    private final EventBus eventBus = ObjectProvider.provide(EventBus.class);

    TodoId todoId;
    Doing doing;
    DoneAt doneAt;

    public Todo(List<DomainEvent> domainEvents) {
        EventHandler<Added> whenAdded = event -> {
            if (event.todoId().equals(todoId)) {
                this.todoId = event.todoId();
                this.doing = event.doing();
            }
        };
        EventHandler<Modified> whenModified = event -> {
            if (event.todoId().equals(todoId)) {
                this.doing = event.doing();
            }
        };
        EventHandler<Done> whenDone = event -> {
            if (event.todoId().equals(todoId)) {
                this.doneAt = new DoneAt();
            }
        };

        eventBus.subscribe(whenAdded);
        eventBus.subscribe(whenModified);
        eventBus.subscribe(whenDone);
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
