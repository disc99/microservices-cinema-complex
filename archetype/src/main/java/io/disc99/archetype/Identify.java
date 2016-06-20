package io.disc99.archetype;


import java.util.UUID;

public class Identify {
    String value;
    public Identify() {
        this.value = UUID.randomUUID().toString();
    }
}
