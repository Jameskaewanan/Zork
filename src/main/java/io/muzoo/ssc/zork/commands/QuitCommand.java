package io.muzoo.ssc.zork.commands;

import io.muzoo.ssc.zork.Game;
import io.muzoo.ssc.zork.commandProcessor.Command;

public class QuitCommand extends Command { // Command to quit the game session

    private Game game;

    public QuitCommand(Game game) {
        this.game = game;
    }

    @Override
    public String description() {
        return "[ quit ] quit current game session and return to the menu";
    }

    @Override
    public void execute(Game game, String[] array) { // Quit game session and display menu
        System.out.println();
        System.out.println("Quitting game session...");
        System.out.println();
        game.output.welcomeScreen();
        Game.quitGame = 1; // Turn on indicator that quit game is active
        Game.isGameRunning = 0; // Switch off indicator that game session is currently running
    }
}
