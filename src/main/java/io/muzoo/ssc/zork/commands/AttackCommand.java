package io.muzoo.ssc.zork.commands;

import io.muzoo.ssc.zork.Game;
import io.muzoo.ssc.zork.commandProcessor.Command;
import io.muzoo.ssc.zork.entityProcesser.Player;
import io.muzoo.ssc.zork.mapProcessor.GenerateMap;
import io.muzoo.ssc.zork.mapProcessor.Room;

import java.util.SortedMap;

public class AttackCommand extends Command {

    private Game game;

    public AttackCommand(Game game) { this.game = game; }

    @Override
    public String description() {
        return "[ attack with <weapon> ] attack monster with specified weapon";
    }

    @Override
    public void execute(Game game, String[] array) {

        for (Room room : GenerateMap.roomList) {
            if (Game.currentRoom.equals(room.name)) {
                if (room.monster == null) {
                    System.out.println("\nNo monsters in the area\n");
                    return;
                }
            }
        }

        if (array.length < 3) {
            System.out.println("\nPlease input attack command in the format of [ attack with <weapon> ]\n");
            return;
        }

        Game.isCombat = 1; // Activate combat sequence
        System.out.println("\nInitiating combat sequence...");
        game.combatLogic(array[0], array[2]);
    }
}
