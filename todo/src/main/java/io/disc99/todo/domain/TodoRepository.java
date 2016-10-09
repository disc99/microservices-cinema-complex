package io.disc99.todo.domain;

import io.disc99.archetype.Repository;

public interface TodoRepository extends Repository {
    Todo findById(TodoId todoId);
}
