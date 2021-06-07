package io.muzoo.ssc.zork.commands;

import io.muzoo.ssc.zork.Game;
import io.muzoo.ssc.zork.commandProcessor.Command;
import io.muzoo.ssc.zork.commandProcessor.CommandFactory;

public class HelpCommand extends Command {

    private Game game;

    public HelpCommand(Game game) {
        this.game = game;
    }

    @Override
    public int numArgs() {
        return 0;
    }

    @Override
    public String description() {
        return "List of all available commands";
    }

    @Override
    public void execute(Game game, String[] array) {

        for (String command : CommandFactory.getCOMMANDS().keySet()) {
            game.output.println(command + " - " + CommandFactory.getCOMMANDS().get(command).description());
        }

    }

    @Override
    public String getCommand() {
        return "help";
    }
}
