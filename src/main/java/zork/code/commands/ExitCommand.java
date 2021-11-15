package zork.code.commands;

import zork.code.Game;
import zork.code.commandProcessor.Command;


public class ExitCommand extends Command { // Command to exit the program

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
        System.out.println("Exiting game...");
        game.exit();
    }

}
