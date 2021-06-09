package io.muzoo.ssc.zork.mapProcessor;

import io.muzoo.ssc.zork.entityProcesser.GenerateMonster;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GenerateRooms extends Room { // Generate Room Objects for the map

    private static String monster = "";

    public static ArrayList<Room> createRooms(String filename) throws FileNotFoundException {
        ArrayList<Room> rooms = new ArrayList<Room>();

        // Search for map file containing data about the map and its rooms
        String filePath = "C:\\Users\\USER\\Desktop\\Zork\\src\\main\\MapInfo\\" + filename;
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            Room room = new Room();
            room.name = scanner.nextLine();
            room.description = scanner.nextLine();

            //skip items and monsters for now
            String[] entityItemLine = scanner.nextLine().split(",");
            monster = entityItemLine[1];
            if (monster.equals("MONSTER"))
                room.monster = null;
            else
                room.monster = GenerateMonster.createMonster();

            String[] neighbourLine = scanner.nextLine().split(",");

            // Create a HashMap of all neighbouring rooms
            room.neighbours.put("north", neighbourLine[0]);
            room.neighbours.put("east", neighbourLine[1]);
            room.neighbours.put("south", neighbourLine[2]);
            room.neighbours.put("west", neighbourLine[3]);

            rooms.add(room);

        }
        scanner.close();

        return rooms;
    }

    public String getMonster() {
        return this.monster;
    }

}
