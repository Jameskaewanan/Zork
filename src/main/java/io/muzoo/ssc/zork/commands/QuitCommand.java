package io.muzoo.ssc.zork.commands;

import io.muzoo.ssc.zork.Game;
import io.muzoo.ssc.zork.commandProcessor.Command;

public class QuitCommand extends Command {

    private Game game;

    public QuitCommand(Game game) {
        this.game = game;
    }

    @Override
    public String description() {
        return "quit current game session and return to the menu";
    }

    @Override
    public void execute(Game game, String[] array) {
        Game.quitGame = 1;
        Game.isGameRunning = 0;
    }

    @Override
    public String getCommand() {
        return "quit";
    }
}
