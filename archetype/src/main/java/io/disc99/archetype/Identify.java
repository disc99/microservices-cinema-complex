package io.disc99.archetype;


import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode
public class Identify {
    String value;
    public Identify() {
        this.value = UUID.randomUUID().toString();
    }
    public Identify(String value) {
        this.value = value;
    }
}
