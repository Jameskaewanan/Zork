package zork.code.commands;

import zork.code.Game;
import zork.code.commandProcessor.Command;

public class InfoCommand extends Command {

    private Game game;

    public InfoCommand(Game game) { this.game = game; }

    @Override
    public String description() {
        return "[ info ] Display information/statistics about the player and the current room and its monster/item";
    }

    @Override
    public void execute(Game game, String[] array) {
        game.output.displayRoom(); // Display information about current room

        System.out.println("============================================================================================\n");

        System.out.println("[ Player Stats ]"); // Display Player Stats
        System.out.println("Health: " + game.player.health);
        System.out.println("Defense: " + (Math.round(game.player.defense *100.0)/100.0));

        System.out.println("\n[ Inventory ]");
        for (String key: game.player.inventory.keySet()) {
            System.out.println(game.player.inventory.get(key).name + " : " + game.player.inventory.get(key).description);
        }
        System.out.println();
    }
}
