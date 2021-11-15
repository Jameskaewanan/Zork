package zork.code.entityProcesser;

import zork.code.itemProcessor.Item;

import java.util.HashMap;

        /*
        Base strength, 0 meaning no strength - can be increased up to 1 for damage multiplier (double dmg)
        Base defense, 0 meaning no defense - can be increased up to 1 for max defense (no dmg received)
        Base agility, 0 meaning no agility - can be increased up to 1 for max agility (guaranteed miss)
        Base intelligence, 5 meaning average intelligence - can be increased up to 10 or minimum of 0


        Strength:       Increments by 0.025 (total of 40 levels)
        Defense         Increments by 0.025 (total of 40 levels)
        Agility         Increments by 0.025 (total of 40 levels)
        Intelligence    Increments by 0.1 (total of 100 levels starting from lvl 0)
         */

public class Player extends Entity{

    //  Skills
    public int lightArmour = 0;
    public int handguns = 0;
    public int melee = 0;
    public int speechcraft = 0;

    public int hacking = 0;
    public int crafting = 0;
    public int firstAid = 0;
    public int marksmanship = 0;

    public int heavyArmour = 0;
    public int heavyWeapons = 0;
    public int athletics = 0;
    public int unarmed = 0;

    //  Additional info
    public String playerClass;

    public Player() {

        //  Basic info
        name = "";
        gender = "";
        race = ""; // Race provides additional buffs but also debuffs, in future can add unique abilities for races


        //  Health
        health = 100;
        maxHealth = 100; // In future multiply value relative to the level of the player

        //  Attributes
        strength = 0;
        defense = 0.1;
        agility = 0;
        intelligence = 5;

        // Others
        isBoss = 0;
        inventory = new HashMap<String, Item>();

    }

}
