package io.muzoo.ssc.zork;

import io.muzoo.ssc.zork.mapProcessor.GenerateMap;
import io.muzoo.ssc.zork.mapProcessor.Room;

public class GameOutput {

    public void println(String msg) {
        System.out.println(msg);
    }
    public void print(String msg) {
        System.out.print(msg);
    }

    public void welcomeScreen() {

        System.out.println();
        System.out.println("############################");
        System.out.println("#                          #");
        System.out.println("#        Weclome To        #");
        System.out.println("#           ZORK           #");
        System.out.println("#                          #");
        System.out.println("############################");

        System.out.println();
        System.out.println("Welcome to a bare bones version of Zork!");
        System.out.println("You will traverse dungeons and stuff");
        System.out.println("You will kill things");
        System.out.println();
        System.out.println("Select from the following options");
        System.out.println("play <map> - choose a map and play");
        System.out.println("load <save name> - load a previous save");
        System.out.println();

    }

    public void mapIntro() {

        if (GenerateMap.filename == "SpaceshipMap") {
            System.out.println();
            System.out.println("You are now playing the Spaceship map");
            System.out.println();

            Game.currentRoom = GenerateMap.roomList.get(0).name;

            System.out.println(GenerateMap.roomList.get(0).name);
            System.out.println(GenerateMap.roomList.get(0).description);
            System.out.println("Possible Movements: " + GenerateMap.roomList.get(0).neighbours);
            System.out.println();

        }else {
            return;
        }
    }

    public static void displayRoom() {

        System.out.println(Game.currentRoom);

        for (Room room : GenerateMap.roomList) {
            if (Game.currentRoom.equals(room.name)) {
                System.out.println();
                System.out.println(room.name);
                System.out.println(room.description);
                System.out.println("Possible Movements: " + room.neighbours);
                System.out.println();
                return;
            }
        }

    }


}
