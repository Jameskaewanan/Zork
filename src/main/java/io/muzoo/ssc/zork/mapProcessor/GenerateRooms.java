package io.muzoo.ssc.zork.mapProcessor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GenerateRooms extends Room {

    private static int i = 0;

    public static ArrayList<Room> createRooms(String filename) throws FileNotFoundException {
        ArrayList<Room> rooms = new ArrayList<Room>();

        String filePath = "C:\\Users\\USER\\Desktop\\Zork\\src\\main\\MapInfo\\" + filename;
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            Room room = new Room();
            room.name = scanner.nextLine();
            room.description = scanner.nextLine();

            //skip items and monsters for now
            scanner.nextLine();

            String[] line = scanner.nextLine().split(",");

            room.neighbours.put("north", line[0]);
            room.neighbours.put("east", line[1]);
            room.neighbours.put("south", line[2]);
            room.neighbours.put("west", line[3]);

            rooms.add(room);

        }
        scanner.close();

        return rooms;
    }

}
