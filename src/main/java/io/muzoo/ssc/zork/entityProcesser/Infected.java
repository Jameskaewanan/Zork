package io.muzoo.ssc.zork.entityProcesser;

public class Infected extends Entity {

    public Infected() {
        name = "Infected";
        description = "A humanoid infected by the parasite, be cautious when approaching...";
        healthPoints = 50;
        maxHealthPoints = 50;
        attackPoints = 40;
        defensePoints = 0;
        inventory = null;
    }

}
