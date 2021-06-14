package io.muzoo.ssc.zork.entityProcesser;

public class Parasite extends Entity {

    public Parasite() {
        name = "Parasite";
        description = "A small biological life-form, deals minuscule amounts damage but can be deadly in large numbers";
        healthPoints = 20;
        maxHealthPoints = 20;
        attackPoints = 5;
        defensePoints = 0.1;
        agilityPoints = 0.6;
        inventory = null;
    }

}
