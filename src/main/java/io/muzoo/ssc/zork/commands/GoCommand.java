package io.muzoo.ssc.zork.commands;

import io.muzoo.ssc.zork.Game;
import io.muzoo.ssc.zork.GameOutput;
import io.muzoo.ssc.zork.commandProcessor.Command;
import io.muzoo.ssc.zork.mapProcessor.GenerateMap;
import io.muzoo.ssc.zork.mapProcessor.Room;

import java.util.Arrays;


public class GoCommand extends Command { // Command to traverse the game map

    private Game game;

    public GoCommand(Game game) { this.game = game;}

    @Override
    public String description() {
        return " [ go <direction> ] Move in a certain direction in the map";
    }

    @Override
    public void execute(Game game, String[] array) {

        if (array.length <= 1) { // Error checking if no argument was given to where the player should move
            System.out.println();
            System.out.println("Please input a valid direction. Available directions: North, East, South, West");
            System.out.println();
            return;
        }

        String direction = array[1];
        String currentRoom = Game.currentRoom;
        String compare = null;
        String[] directionList = {"north","east","south","west"};

        for (Room room : GenerateMap.roomList) {
            if (!Arrays.asList(directionList).contains(direction)) { // Error checking if argument given is not a valid direction
                System.out.println();
                System.out.println("Please input a valid direction. Available directions: North, East, South, West");
                System.out.println();
                return;
            }
            if (room.name.equals(currentRoom)) { // If chosen direction does not lead to anywhere error will pop up
                compare = room.neighbours.get(direction);
                if (compare.equals("%")) {
                    System.out.println();
                    System.out.println("Cannot go to this room as it does not exist");
                    System.out.println();
                }
                else { // Change currentRoom to new room to indicate a movement from one room the the next
                    Game.currentRoom = room.neighbours.get(direction);
                    GameOutput.displayRoom(); // Display details of the next room (now currentRoom)
                    return;
                }

            }
        }
    }
}
