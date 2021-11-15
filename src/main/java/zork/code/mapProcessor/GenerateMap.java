package zork.code.mapProcessor;

import zork.code.Game;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class GenerateMap { // Once "play" command has activated a game session, generate the map

    public static String filename;
    private static GenerateRooms generateRooms = new GenerateRooms();
    public static ArrayList<Room> roomList;
    private static Room startingRoom;

    public static void map() throws FileNotFoundException { // Generates the map (a list of Room Objects)

        Game.isGameRunning = 1; // Switch on indicator that a game session has been activated
        filename = "SpaceshipMap";


        roomList = generateRooms.createRooms(filename); // Generate the map from the map text file
        startingRoom = roomList.get(0); // Set the starting room
    }

}
