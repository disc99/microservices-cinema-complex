package io.disc99.todo.application;

import io.disc99.archetype.Command;
import io.disc99.archetype.Identify;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@AllArgsConstructor
@Getter
@Accessors(fluent = true)
public class Do implements Command {
    private String identify;
}
