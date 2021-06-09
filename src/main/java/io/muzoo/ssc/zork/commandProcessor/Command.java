package io.muzoo.ssc.zork.commandProcessor;

import io.muzoo.ssc.zork.Game;

import java.io.FileNotFoundException;

public abstract class Command {

    public abstract String description();

    public abstract void execute(Game game, String[] array);

    public abstract String getCommand();

}
