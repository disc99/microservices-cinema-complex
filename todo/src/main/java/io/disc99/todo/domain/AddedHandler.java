package io.disc99.todo.domain;

import io.disc99.archetype.EventHandler;
import io.disc99.archetype.EventStore;
import io.disc99.archetype.EventStreamId;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AddedHandler implements EventHandler<Added> {

    private EventStore eventStore;

    @Override
    public void on(Added event) {
        eventStore.add(new EventStreamId(Added.class, event.todoId()), event);
    }
}
