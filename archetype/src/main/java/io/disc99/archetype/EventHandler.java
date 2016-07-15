package io.disc99.archetype;

public interface EventHandler<T extends DomainEvent> {
    void on(T event);
}
