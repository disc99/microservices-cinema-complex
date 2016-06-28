package io.disc99.todo.domain;

import io.disc99.archetype.DomainEvent;
import io.disc99.archetype.Identify;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Added implements DomainEvent {
    private Identify identify;
    private Doing doing;

}
