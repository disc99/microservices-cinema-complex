package io.disc99.archetype;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class CommandBus {
    private Set<CommandHandler> holder;

    public CommandBus() {
        this.holder = new HashSet<>();
    }

    public void register(CommandHandler<?> handler) {
        holder.add(handler);
    }

    @SuppressWarnings("unchecked")
    public void dispatch(Command command) {
        Predicate<CommandHandler> byCommand = handler -> Arrays.stream(handler.getClass().getGenericInterfaces())
                .filter(ParameterizedType.class::isInstance)
                .anyMatch(type -> ParameterizedType.class.cast(type).getActualTypeArguments()[0] == command.getClass());

        holder.stream()
                .filter(byCommand)
                .forEach(handler -> handler.handle(command));
    }
}
