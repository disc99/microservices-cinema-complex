package io.disc99.archetype;

public interface EventStore {

    void add(EventStreamId eventId, DomainEvent event);

    EventStream stream(Class<? extends Entity> clazz, Identify identify);
}
