package io.disc99.todo.application;

import io.disc99.archetype.Command;
import io.disc99.todo.domain.Doing;
import io.disc99.archetype.Identify;
import io.disc99.todo.domain.TodoId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@AllArgsConstructor
@Getter
@Accessors(fluent = true)
public class Modify implements Command {
    private TodoId identify;
    private Doing doing;
}
