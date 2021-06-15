package io.muzoo.ssc.zork.entityProcesser;

import io.muzoo.ssc.zork.itemProcessor.Item;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Entity { // Blueprint for Entities (Player and Monsters)

    public String name;
    public String description;
    public int healthPoints;
    public int maxHealthPoints;
    public int attackPoints;
    public double defensePoints; // Base defense, 0 meaning no defense - can be increased up to 1
    public double agilityPoints; // Base agility, 0 meaning no agility - cab be increased up to 1
    public int isBoss;
    public HashMap<String, Item> inventory;

}
