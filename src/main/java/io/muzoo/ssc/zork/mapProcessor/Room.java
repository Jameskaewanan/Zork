package io.muzoo.ssc.zork.mapProcessor;

import java.util.HashMap;

public class Room {

    public String name;
    public String description;
    //public Item item;
    //public Monster monster;
    public HashMap<String, String> neighbours = new HashMap<String, String>();

}
