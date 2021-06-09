package io.muzoo.ssc.zork;

import io.muzoo.ssc.zork.mapProcessor.GenerateMap;
import io.muzoo.ssc.zork.mapProcessor.GenerateRooms;
import io.muzoo.ssc.zork.mapProcessor.Room;

public class GameOutput { // Controls the majority of outputs to the terminal

    public void println(String msg) {
        System.out.println(msg);
    }
    public void print(String msg) {
        System.out.print(msg);
    }

    public void welcomeScreen() { // Welcome screen, interface for main_loop

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
        System.out.println("============================================================================================");
        System.out.println();
        System.out.println("Select from the following options");
        System.out.println("play | load | help | exit");
        System.out.println();

    }

    public void mapIntro() { // Intro screen for the  game session, starts off by displaying starting room details

        if (GenerateMap.filename == "SpaceshipMap") {
            System.out.println();
            System.out.println("You are now playing the Spaceship map");
            System.out.println();

            displayStartingRoom();

        }else {
            return;
        }
    }

    public static void displayStartingRoom() {

        Game.currentRoom = GenerateMap.roomList.get(0).name;

        System.out.println(GenerateMap.roomList.get(0).name);
        System.out.println(GenerateMap.roomList.get(0).description);

        if (GenerateMap.roomList.get(0).monster == null)
            System.out.println("No monsters in this room");
        else
            System.out.println(GenerateMap.roomList.get(0).monster.name);

        System.out.print("Available movements: ");
        System.out.print("north = " + GenerateMap.roomList.get(0).neighbours.get("north") + " | ");
        System.out.print("east = " + GenerateMap.roomList.get(0).neighbours.get("east") + " | ");
        System.out.print("south = " + GenerateMap.roomList.get(0).neighbours.get("south") + " | ");
        System.out.println("west = " + GenerateMap.roomList.get(0).neighbours.get("west") + " ");

        System.out.println();

    }

    public static void displayRoom() { // Displays current room of the map

        for (Room room : GenerateMap.roomList) {
            if (Game.currentRoom.equals(room.name)) { // Finds the current room amongst list of rooms of the map to display correct room
                System.out.println();
                System.out.println(room.name);
                System.out.println(room.description);

                if (room.monster == null)
                    System.out.println("No monsters in this room");
                else
                    System.out.println(room.monster.name);

                System.out.print("Available movements: ");
                System.out.print("north = " + room.neighbours.get("north") + " | ");
                System.out.print("east = " + room.neighbours.get("east") + " | ");
                System.out.print("south = " + room.neighbours.get("south") + " | ");
                System.out.println("west = " + room.neighbours.get("west") + " ");

                System.out.println();
                return;
            }
        }

    }


}
