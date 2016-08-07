package io.disc99.todo.domain;

import io.disc99.ObjectProvider;
import io.disc99.archetype.EventBus;
import io.disc99.archetype.Identify;
import io.disc99.archetype.ValueObject;

import java.util.ArrayList;
import java.util.List;

public class TodoList implements ValueObject {

    private final EventBus eventBus = ObjectProvider.provide(EventBus.class);
    List<Todo> list;

    public TodoList() {
        list = new ArrayList<>();
    }

    public void add(TodoId todoId, Doing doing) {
        eventBus.apply(new Added(todoId, doing));
    }
}
