package io.disc99.archetype;

public interface EventStore {

    void add(EventStreamId eventId, DomainEvent event);

    EventStream stream(Class<DomainEvent> clazz, Identify identify);
}
