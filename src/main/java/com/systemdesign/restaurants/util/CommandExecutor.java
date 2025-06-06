package com.systemdesign.restaurants.util;

import jakarta.annotation.PostConstruct;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CommandExecutor {

    private final ApplicationContext applicationContext;
    private final Map<Class<?>, Command<?,?>> commands = new HashMap<>();

    public CommandExecutor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @PostConstruct
    public void registerCommands() {
        Map<String, Command> beans = applicationContext.getBeansOfType(Command.class);
        for(Command<?,?> command : beans.values()) {
            commands.put(command.getClass(), command);
        }
    }

    public <I,O> O execute(Class<? extends Command<I,O>> clazz, I input) {
        Command<I,O> command =  (Command<I,O>) commands.get(clazz);
        if(command == null) {
            throw new IllegalArgumentException("Command not found");
        }
        return command.execute(input);
    }
}
