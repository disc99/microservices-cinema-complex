package io.disc99.archetype;

import lombok.Value;
import lombok.experimental.Accessors;

@Value
@Accessors(fluent = true)
public class EventStreamId {
    Class<? extends DomainEvent> clazz;
    Identify identify;
}
