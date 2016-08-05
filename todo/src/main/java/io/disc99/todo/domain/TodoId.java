package io.disc99.todo.domain;


import java.util.UUID;

public class TodoId {
    String value;
    TodoId(String value) {
        this.value = value;
    }
    TodoId() {
        this.value = UUID.randomUUID().toString();
    }
}
