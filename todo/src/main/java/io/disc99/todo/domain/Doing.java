package io.disc99.todo.domain;

import io.disc99.archetype.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@AllArgsConstructor
@Getter
@Accessors(fluent = true)
public class Doing implements ValueObject {
    private String value;
}
