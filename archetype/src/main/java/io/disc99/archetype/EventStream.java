package io.disc99.archetype;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.util.List;

@AllArgsConstructor
@Getter
@Accessors(fluent = true)
public class EventStream {
    Identify identify;
    long version;
    List<DomainEvent> events;
}
