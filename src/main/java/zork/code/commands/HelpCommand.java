package zork.code.commands;

import zork.code.Game;
import zork.code.commandProcessor.Command;
import zork.code.commandProcessor.CommandFactory;

public class HelpCommand extends Command { // Command to display all available commands and usage

    private Game game;

    public HelpCommand(Game game) {
        this.game = game;
    }

    @Override
    public String description() {
        return "[ help ] List of all available commands";
    }

    @Override
    public void execute(Game game, String[] array) {
        System.out.println();
        System.out.println("A list of all available commands and instructions on how to use them.");
        System.out.println();
        for (String command : CommandFactory.getCOMMANDS().keySet()) {
            System.out.println(command + "   -   " + CommandFactory.getCOMMANDS().get(command).description());
        }
        System.out.println();
    }
}
