package io.disc99.todo.domain;


import io.disc99.archetype.Identify;

import java.util.UUID;

public class TodoId implements Identify {
    String value;
    public TodoId(String value) {
        this.value = value;
    }
    public TodoId() {
        this.value = UUID.randomUUID().toString();
    }
}
