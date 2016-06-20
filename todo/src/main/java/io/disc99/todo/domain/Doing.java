package io.disc99.todo.domain;

import io.disc99.archetype.ValueObject;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Doing implements ValueObject {
    private String value;
}
