package io.muzoo.ssc.zork.mapProcessor;

import io.muzoo.ssc.zork.Game;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class GenerateMap { // Once "play" command has activated a game session, generate the map

    public static String filename;
    private static GenerateRooms generateRooms = new GenerateRooms();
    public static ArrayList<Room> roomList;
    private static Room startingRoom;

    public static void map(String[] array) throws FileNotFoundException { // Generates the map (a list of Room Objects)

        if (array[1].equals("spaceship")) { // Check if argument matches that of available maps
            Game.isGameRunning = 1; // Switch on indicator that a game session has been activated
            filename = "SpaceshipMap";
        } else {
            System.out.println();
            System.out.println("Please input a valid map. Available maps: Spaceship");
            System.out.println();
            return;
        }

        roomList = generateRooms.createRooms(filename); // Generate the map from the map text file
        startingRoom = roomList.get(0); // Set the starting room
    }

}
