package zork.code.commands;

import zork.code.Game;
import zork.code.commandProcessor.Command;
import zork.code.itemProcessor.Item;
import zork.code.mapProcessor.GenerateMap;
import zork.code.mapProcessor.Room;

public class TakeCommand extends Command {

    private Game game;

    public TakeCommand(Game game) { this.game = game; }

    @Override
    public String description() {
        return "[ take <item> ] Take an item from the room";
    }

    @Override
    public void execute(Game game, String[] array) {

        if (array.length < 2) {
            System.out.println("Please input take command in the format of [ take <item> ]");
            return;
        }

        String item = array[1];

        for (Room room : GenerateMap.roomList) {
            if (Game.currentRoom.equals(room.name)) {
                if (room.item == null) {
                    System.out.println("\nNo item in the room\n");
                    return;
                }
                if (room.item != null && !item.equals(room.item.name.toLowerCase())) {
                    System.out.println("\nItem does not exist in the room");
                    System.out.println("Available item in the room: " + room.item.name + "\n");
                    return;
                }
                if (room.item != null && item.equals(room.item.name.toLowerCase())) {
                    Item temp = room.item;
                    game.player.inventory.put(item, temp);
                    System.out.println("\n" + room.item.name + " put into inventory\n");
                    room.item = null;
                    return;
                }
            }
        }
    }
}
