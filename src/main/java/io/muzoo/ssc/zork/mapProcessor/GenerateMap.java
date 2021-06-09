package io.muzoo.ssc.zork.mapProcessor;

import io.muzoo.ssc.zork.Game;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class GenerateMap {

    public static String filename;
    private static GenerateRooms generateRooms = new GenerateRooms();
    public static ArrayList<Room> roomList;
    private static Room startingRoom;

    public static void map(String[] array) throws FileNotFoundException {

        if (array[1].equals("spaceship")) {
            filename = "SpaceshipMap";
            Game.isGameRunning = 1;
        } else {
            System.out.println("Invalid map");
            return;
        }

        roomList = generateRooms.createRooms(filename);
        startingRoom = roomList.get(0);
    }

}
