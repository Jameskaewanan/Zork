package zork.code.commands;

import zork.code.Game;
import zork.code.commandProcessor.Command;

public class DropCommand extends Command {

    private Game game;

    public DropCommand(Game game) {
        this.game = game;
    }

    @Override
    public String description() {
        return "[ drop <item> ] Drops the specified item from your inventory, item will be non-recoverable";
    }

    @Override
    public void execute(Game game, String[] array) {

        if (array.length < 2) {
            System.out.println("\nPlease input drop command in the format of [ drop <item> ]\n");
            return;
        }

        String item = array[1];

        if (Game.player.inventory.size() == 0) {
            System.out.println("\nNothing in inventory\n");
            return;
        }
        else if (Game.player.inventory.containsKey(item)) {
            System.out.println("\n" + Game.player.inventory.get(item).name + " dropped\n");
            Game.player.inventory.remove(item);
            return;
        }
        else if (!Game.player.inventory.containsKey(item)) {
            System.out.println("\n" + Game.player.inventory.get(item).name + " not in inventory\n");
            return;
        }
    }
}
