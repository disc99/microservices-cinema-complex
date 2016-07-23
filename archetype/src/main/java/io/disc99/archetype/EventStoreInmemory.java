package io.disc99.archetype;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

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
        return events.stream()
                // TODO filter by identify
                // TODO new EventStream logic
                .collect(collectingAndThen(toList(), events -> new EventStream(0, events)));
    }
}
