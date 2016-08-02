package io.disc99.todo.domain;

import io.disc99.archetype.*;
import io.disc99.ObjectProvider;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Todo implements Entity {

    private final EventBus eventBus = ObjectProvider.provide(EventBus.class);

    Identify identify;
    Doing doing;
    DoneAt doneAt;

    public Todo(List<DomainEvent> domainEvents) {
        // TODO
    }

    public void modified(Doing doing) {
        Modified modified = new Modified(identify, doing);
        eventBus.apply(modified);
    }

    public void done() {
        Done done = new Done(identify);
        eventBus.apply(done);
    }
}
