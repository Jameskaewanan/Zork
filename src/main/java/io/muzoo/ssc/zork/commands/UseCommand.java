package io.muzoo.ssc.zork.commands;

import io.muzoo.ssc.zork.Game;
import io.muzoo.ssc.zork.commandProcessor.Command;

public class UseCommand extends Command {

    private Game game;

    public UseCommand(Game game) { this.game = game; }

    @Override
    public String description() {
        return "[ use <item> ] Use a consumable on the player";
    }

    @Override
    public void execute(Game game, String[] array) {

        if (array.length < 2) {
            System.out.println("Please input use command in the format of [ use <item> ]");
            return;
        }

        String item = array[1];

        if (Game.player.inventory.size() == 0) {
            System.out.println("\nNothing in inventory\n");
            return;
        }
        else if (Game.player.inventory.containsKey(item) && Game.player.inventory.get(item).itemType == 1) {
            Game.player.healthPoints = Game.player.healthPoints + Game.player.inventory.get(item).buffs;
            System.out.println("\n" + Game.player.inventory.get(item).name + " used\n");
            Game.player.inventory.remove(item);
            return;
        }
        else if (Game.player.inventory.containsKey(item) && Game.player.inventory.get(item).itemType == 0) {
            System.out.println("\n" + Game.player.inventory.get(item).name + " is not a valid consumable\n");
            return;
        }
        else if (!Game.player.inventory.containsKey(item)) {
            System.out.println("\n" + Game.player.inventory.get(item).name + " not in inventory\n");
            return;
        }

    }
}
