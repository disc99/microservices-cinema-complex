package io.disc99.archetype.impl;

import io.disc99.archetype.DomainEvent;
import io.disc99.archetype.EventId;
import lombok.Value;
import lombok.experimental.Accessors;

@Value
@Accessors(fluent = true)
class StoredEvent {
    EventId eventId;
    DomainEvent domainEvent;
}
