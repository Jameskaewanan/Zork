package io.muzoo.ssc.zork.commandProcessor;

import io.muzoo.ssc.zork.Game;

import java.io.FileNotFoundException;

public abstract class Command { // Blueprint for Command Objects

    public abstract String description(); // Description of the command

    public abstract void execute(Game game, String[] array) throws FileNotFoundException; // Execution process of the command

}
