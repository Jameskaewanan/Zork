package io.muzoo.ssc.zork.mapProcessor;

import io.muzoo.ssc.zork.entityProcesser.GenerateMonster;
import io.muzoo.ssc.zork.itemProcessor.GenerateItem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GenerateRooms extends Room { // Generate Room Objects for the map

    public String monsterLine = "";
    public String itemLine = "";

    public ArrayList<Room> createRooms(String filename) throws FileNotFoundException {
        ArrayList<Room> rooms = new ArrayList<Room>();


        // Search for map file containing data about the map and its rooms
        String filePath = "C:\\Users\\USER\\Desktop\\Zork\\src\\main\\MapInfo\\" + filename;
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            Room room = new Room();
            room.name = scanner.nextLine();
            room.description = scanner.nextLine();

            String[] entityItemLine = scanner.nextLine().split(",");
            monsterLine = entityItemLine[1];

            if (monsterLine.equals("MONSTER")) {
                room.monster = null;
            }
            else{
                room.monster = GenerateMonster.createMonster(monsterLine);
            }


            itemLine = entityItemLine[0];
            if (itemLine.equals("ITEM"))
                room.item = null;
            else
                room.item = GenerateItem.createItem(itemLine);

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
}
