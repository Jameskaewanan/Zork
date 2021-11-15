package zork.code.mapProcessor;

import zork.code.entityProcesser.Entity;
import zork.code.itemProcessor.Item;

import java.util.HashMap;

public class Room { // Blueprint for Room Object

    public String name; // Name of room
    public String description; // Description of room
    public Entity monster; // Define monsters within the room
    public Item item; // Define items contained within the room
    public HashMap<String, String> neighbours = new HashMap<String, String>(); // Define connected rooms

}
