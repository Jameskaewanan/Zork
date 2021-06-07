package io.muzoo.ssc.zork.commands;

import io.muzoo.ssc.zork.Game;
import java.util.List;

public abstract class Command {

    public abstract String getCommand();

    public abstract void execute(Game game, List<String> args);

    public abstract String description();

}
