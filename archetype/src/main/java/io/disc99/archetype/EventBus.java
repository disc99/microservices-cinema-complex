package io.disc99.archetype;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class EventBus {

    private Set<EventHandler> handlers;

    public EventBus(Set<EventHandler> handlers) {
        this.handlers = handlers;
    }

    public EventBus() {
        this.handlers = new HashSet<>();
    }


    public void subscribe(EventHandler handler) {
        handlers.add(handler);
    }


    // TODO method name
    // apply(Axon Framework)
    // publish(IDDD samples)
    // dispatch, or ...
    @SuppressWarnings("unchecked")
    public void apply(DomainEvent event) {
        Predicate<EventHandler> byEvent = handler -> Arrays.stream(handler.getClass().getGenericInterfaces())
                .filter(ParameterizedType.class::isInstance)
                .anyMatch(type -> ParameterizedType.class.cast(type).getActualTypeArguments()[0] == event.getClass());

        handlers.stream()
                .filter(byEvent)
                .forEach(handler -> handler.on(event));
    }
}
