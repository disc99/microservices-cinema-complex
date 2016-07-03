package io.disc99.todo.domain;

import io.disc99.archetype.Identify;
import io.disc99.archetype.Repository;

public interface TodoRepository extends Repository {
    Todo find(Identify identify);
}
