package io.muzoo.ssc.zork.commandProcessor;

import io.muzoo.ssc.zork.Game;
import io.muzoo.ssc.zork.commands.*;


import java.util.HashMap;
import java.util.Map;

public class CommandFactory { // Assembles commands, assign keywords to command objects

    public static Map<String, Command> COMMANDS = new HashMap<>();

    public static void RegisteredCommands(Game game) { // A HashMap list of available commands

        COMMANDS.put("exit", new ExitCommand(game));
        COMMANDS.put("help", new HelpCommand(game));
        COMMANDS.put("play", new PlayCommand(game));
        COMMANDS.put("quit", new QuitCommand(game));
        COMMANDS.put("go", new GoCommand(game));
        COMMANDS.put("attack", new AttackCommand(game));

    }

    public static Command lookupExecute(String[] array){ // Look up the command in the HashMap and if it exists executes it
        for (String key: COMMANDS.keySet()) {
            if (array[0].equals(key))
                return COMMANDS.get(key);
        }
        return null;
    }

    public static Map<String, Command> getCOMMANDS() {
        return COMMANDS;
    }

}
