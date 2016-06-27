package io.disc99.todo.domain;

import io.disc99.archetype.Entity;
import io.disc99.archetype.Identify;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Todo implements Entity {

    Identify identify;
    Doing doing;
    DoneAt doneAt;

    public void modifed() {
        // TODO
    }

    public void done() {
        // TODO
    }
}
