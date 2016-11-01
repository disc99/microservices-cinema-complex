package io.disc99.todo.domain;

import io.disc99.archetype.*;
import io.disc99.ObjectProvider;
import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static java.util.Arrays.asList;

@AllArgsConstructor
@Accessors(fluent = true)
public class Todo implements Entity {

    private final EventBus eventBus = ObjectProvider.provide(EventBus.class);

    TodoId todoId;
    Doing doing;
    DoneAt doneAt;

    public Todo(List<DomainEvent> domainEvents) {
        EventHandler<Added> whenAdded = new EventHandler<Added>() {
            @Override
            public void on(Added event) {
                    Todo.this.todoId = event.todoId();
                    Todo.this.doing = event.doing();
            }
        };
        EventHandler<Modified> whenModified = event -> {
            this.doing = event.doing();
        };
        EventHandler<Done> whenDone = event -> {
            this.doneAt = new DoneAt();
        };

        eventBus.subscribe(whenAdded);
        eventBus.subscribe(whenModified);
        eventBus.subscribe(whenDone);

        // TODO
        EventBus eventBus = new EventBus(new HashSet<>(asList(whenAdded, whenModified, whenDone)));
        domainEvents.forEach(eventBus::apply);
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
