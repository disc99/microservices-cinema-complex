package io.disc99.archetype;

import java.util.ArrayList;
import java.util.List;

public class EventStoreInMemory implements EventStore {

    List<DomainEvent> events;

    public EventStoreInMemory() {
        events = new ArrayList<>();
    }

    @Override
    public void add(DomainEvent event) {
        events.add(event);
    }

    @Override
    public EventStream stream(Class<DomainEvent> clazz, Identify identify) {
        return null;
    }
}
