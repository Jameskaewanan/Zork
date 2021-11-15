package zork.code.entityProcesser;

import zork.code.itemProcessor.Item;

import java.util.HashMap;

public abstract class Entity { // Blueprint for Entities (Player and Monsters)

    public String name;
    public String description;
    public String gender; // can be "male" or "female"
    public String race;

    public int health; // Defines the health of the entity
    public int maxHealth; // Defines max health

    public double strength; // Base strength, 0 meaning no strength - can be increased up to 1 for damage multiplier (double dmg)
    public double defense; // Base defense, 0 meaning no defense - can be increased up to 1 for max defense (no dmg received)
    public double agility; // Base agility, 0 meaning no agility - can be increased up to 1 for max agility (guaranteed miss)
    public double intelligence; // Base intelligence, 5 meaning average intelligence - can be increased up to 10 or minimum of 0

    public int isBoss;
    public HashMap<String, Item> inventory;

}
