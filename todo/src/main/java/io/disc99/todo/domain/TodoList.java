package io.disc99.todo.domain;

import io.disc99.archetype.ValueObject;

import java.util.ArrayList;
import java.util.List;

public class TodoList implements ValueObject {
    List<Todo> list;

    public TodoList() {
        list = new ArrayList<>();
    }

    public void add() {
        // TODO
    }
}
