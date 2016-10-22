package io.disc99.archetype.impl;

import io.disc99.archetype.*;
import lombok.Value;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class EventStoreInMemory implements EventStore {

    List<StoredEvent> events;

    public EventStoreInMemory() {
        events = new ArrayList<>();
    }

    @Override
    public void add(EventStreamId eventId, DomainEvent event) {
        events.add(new StoredEvent(eventId, event));
    }

    @Override
    public EventStream stream(Class<? extends Entity> clazz, Identify identify) {
        return events.stream()
                .filter(event -> event.eventId().clazz() == clazz && event.eventId().identify().equals(identify))
                .map(StoredEvent::domainEvent)
                .collect(collectingAndThen(toList(), events -> new EventStream(identify, 0, events)));
    }

    @Value
    @Accessors(fluent = true)
    static class StoredEvent {
        EventStreamId eventId;
        DomainEvent domainEvent;
    }
}
