package io.disc99.todo.domain;


import io.disc99.archetype.Identify;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.util.UUID;

@Getter
@Accessors(fluent = true)
@EqualsAndHashCode
public class TodoId implements Identify {
    String value;
    public TodoId(String value) {
        this.value = value;
    }
    public TodoId() {
        this.value = UUID.randomUUID().toString();
    }
}
