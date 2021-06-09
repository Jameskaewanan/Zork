package io.muzoo.ssc.zork.commands;

import io.muzoo.ssc.zork.Game;
import io.muzoo.ssc.zork.GameOutput;
import io.muzoo.ssc.zork.commandProcessor.Command;
import io.muzoo.ssc.zork.mapProcessor.GenerateMap;
import io.muzoo.ssc.zork.mapProcessor.Room;


public class GoCommand extends Command {

    private Game game;

    public GoCommand(Game game) { this.game = game;}

    @Override
    public String description() {
        return "Move in a certain direction";
    }

    @Override
    public void execute(Game game, String[] array) {

        String direction = array[1];
        String currentRoom = Game.currentRoom;
        String compare = null;

        for (Room room : GenerateMap.roomList) {
            if (room.name.equals(currentRoom)) {
                compare = room.neighbours.get(direction);
                if (compare.equals("%"))
                    System.out.println("Cannot go to this room as it does not exist");
                else {
                    Game.currentRoom = room.neighbours.get(direction);
                    GameOutput.displayRoom();
                    return;
                }

            }
        }
    }

    @Override
    public String getCommand() {
        return "go";
    }
}
