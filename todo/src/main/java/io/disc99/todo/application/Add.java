package io.disc99.todo.application;

import io.disc99.todo.application.Command;
import io.disc99.todo.domain.Doing;
import io.disc99.todo.domain.Identify;

public class Add implements Command {
    private Identify identify;
    private Doing doing;
}
