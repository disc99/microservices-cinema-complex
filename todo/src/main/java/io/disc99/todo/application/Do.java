package io.disc99.todo.application;

import io.disc99.archetype.Command;
import io.disc99.archetype.Identify;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Do implements Command {
    private Identify identify;
}
