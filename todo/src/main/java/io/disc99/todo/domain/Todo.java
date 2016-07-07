package io.disc99.todo.domain;

import io.disc99.archetype.Entity;
import io.disc99.archetype.EventBus;
import io.disc99.archetype.Identify;
import io.disc99.todo.BeanProvider;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Todo implements Entity {

    Identify identify;
    Doing doing;
    DoneAt doneAt;

    public void modified(Doing doing) {
        Modified modified = new Modified(identify, doing);

        BeanProvider.provide(EventBus.class)
                .dispatch(modified);
    }

    public void done() {
        // TODO
    }
}
