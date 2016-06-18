package io.disc99.todo.domain;

import io.disc99.archetype.DomainEvent;
import io.disc99.archetype.Identify;

public class Done implements DomainEvent {
    Identify identify;
    DoneAt doneAt;
}
