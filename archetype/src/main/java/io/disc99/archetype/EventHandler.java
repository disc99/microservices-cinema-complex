package io.disc99.archetype;

public interface EventHandler<T extends DomainEvent> {
    void handle(T event);
}
