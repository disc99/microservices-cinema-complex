package io.disc99.archetype;

public interface CommandHandler<T extends Command> {
    void handle(T command);
}
