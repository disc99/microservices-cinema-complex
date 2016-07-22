package io.disc99.archetype;

public interface EventStore {

    void add(DomainEvent event);

    EventStream stream(Class<DomainEvent> clazz, Identify identify);
}
