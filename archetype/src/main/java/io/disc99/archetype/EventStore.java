package io.disc99.archetype;

import io.disc99.archetype.EventId;

public interface EventStore {

    void add(EventId eventId, DomainEvent event);

    EventStream stream(Class<DomainEvent> clazz, Identify identify);
}
