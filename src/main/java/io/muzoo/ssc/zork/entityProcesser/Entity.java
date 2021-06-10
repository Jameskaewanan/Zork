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
    public int defensePoints;
    public HashMap<String, Item> inventory;

}
