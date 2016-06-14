package io.disc99.todo.domain;

public class Done implements DomainEvent {
    Identify identify;
    DoneAt doneAt;
}
