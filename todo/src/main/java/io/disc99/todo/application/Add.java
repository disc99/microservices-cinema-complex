package io.disc99.todo.application;

import io.disc99.archetype.Command;
import io.disc99.todo.domain.Doing;
import io.disc99.archetype.Identify;

public class Add implements Command {
    private Identify identify;
    private Doing doing;
}
