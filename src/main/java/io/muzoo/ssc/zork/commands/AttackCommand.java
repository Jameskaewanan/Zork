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

        String weapon = "fist"; // Placeholder weapon (implement Weapon Objects in the future)
        String currentRoom = Game.currentRoom;

        for (Room room : GenerateMap.roomList) {
            if (currentRoom.equals(room.name)) {
                if (room.monster != null){

                    System.out.println("\n" + "Attacking " + room.monster.name + " with fists..." + "\n");

                    room.monster.healthPoints = room.monster.healthPoints - Game.player.attackPoints;
                    System.out.println("\n" + "Dealt " + Game.player.attackPoints + " Damage to " + room.monster.name + "\n");

                    Game.player.healthPoints = Game.player.healthPoints - room.monster.attackPoints;

                    if (room.monster.healthPoints <= 0) {
                        System.out.println("\n" + room.monster.name + " Defeated\n");
                        room.monster = null;
                        return;
                    }

                    if (Game.player.healthPoints <= 0) {
                        System.out.println("\nYou are dead, no big surprise\n");
                        Game.quitGame = 1;
                        return;
                    }

                }
                if (room.monster == null) {
                    System.out.println("\nNo monsters are in the room\n");
                    return;
                }
            }
        }

    }
}
