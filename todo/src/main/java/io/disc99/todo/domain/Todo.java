package io.disc99.todo.domain;

import io.disc99.archetype.*;
import io.disc99.todo.ObjectProvider;
import io.disc99.archetype.impl.EventBusInMemory;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;

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
//        EventHandler<Added> whenAdded = event -> {
//                Todo.this.todoId = event.todoId();
//                Todo.this.doing = event.doing();
//        };
//        EventHandler<Modified> whenModified = event -> {
//            this.doing = event.doing();
//        };
//        EventHandler<Done> whenDone = event -> {
//            this.doneAt = new DoneAt();
//        };

        eventBus.subscribe(new WhenAdded());
        eventBus.subscribe(new WhenModified());
        eventBus.subscribe(new WhenDone());

        // TODO
        EventBus eventBus = new EventBusInMemory(new HashSet<>(asList(new WhenAdded(), new WhenModified(), new WhenDone())));
        domainEvents.forEach(eventBus::apply);
    }

    private class WhenAdded implements EventHandler<Added> {
        @Override
        public void on(Added event) {
            Todo.this.todoId = event.todoId();
            Todo.this.doing = event.doing();
        }
    }

    private class WhenModified implements EventHandler<Modified> {
        @Override
        public void on(Modified event) {
            Todo.this.doing = event.doing();
        }
    }

    private class WhenDone implements EventHandler<Done> {
        @Override
        public void on(Done event) {
            Todo.this.doneAt = new DoneAt();
        }
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
