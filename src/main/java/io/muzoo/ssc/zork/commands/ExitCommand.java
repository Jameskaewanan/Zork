package io.muzoo.ssc.zork.commands;

import io.muzoo.ssc.zork.Game;
import io.muzoo.ssc.zork.commandProcessor.Command;


public class ExitCommand extends Command {

    private Game game;

    public ExitCommand(Game game) {
        this.game = game;
    }

    @Override
    public String description() {
        return "[ exit ] Exit the game";
    }

    @Override
    public void execute(Game game, String[] array) {
        System.out.println();
        game.output.println("Exiting game...");
        game.exit();
    }

    @Override
    public String getCommand() {
        return "exit";
    }


}
