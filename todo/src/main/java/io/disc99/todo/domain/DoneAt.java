package io.disc99.todo.domain;

import io.disc99.archetype.ValueObject;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Accessors(fluent = true)
public class DoneAt implements ValueObject {
    private LocalDateTime value;
    DoneAt() {
        value = LocalDateTime.now();
    }
}
