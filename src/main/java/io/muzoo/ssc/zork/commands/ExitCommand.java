package io.muzoo.ssc.zork.commands;

import io.muzoo.ssc.zork.Game;
import io.muzoo.ssc.zork.commandProcessor.Command;


public class ExitCommand extends Command {

    private Game game;

    public ExitCommand(Game game) {
        this.game = game;
    }

    @Override
    public int numArgs() {
        return 0;
    }

    @Override
    public String description() {
        return "Exit the game";
    }

    @Override
    public void execute(Game game, String[] array) {
        game.output.println("Exiting game");
        game.exit();
    }

    @Override
    public String getCommand() {
        return "exit";
    }


}
