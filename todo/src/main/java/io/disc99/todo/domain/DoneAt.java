package io.disc99.todo.domain;

import io.disc99.archetype.ValueObject;

import java.time.LocalDateTime;

public class DoneAt implements ValueObject {
    private LocalDateTime value;
}
