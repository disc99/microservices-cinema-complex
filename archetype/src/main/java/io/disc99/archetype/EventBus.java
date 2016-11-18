package io.disc99.archetype;

public interface EventBus {
    void subscribe(EventHandler handler);

    // TODO method name
    // apply(Axon Framework)
    // publish(IDDD samples)
    // dispatch, or ...
    @SuppressWarnings("unchecked")
    void apply(DomainEvent event);
}
