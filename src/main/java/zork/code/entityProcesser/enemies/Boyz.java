package zork.code.entityProcesser.enemies;

import zork.code.entityProcesser.Entity;

public class Boyz extends Entity {

    public Boyz() {
        name = "Boyz";
        description = "An Ork Boyz, the heart and soul of an Ork Warband. Able to deal considerable damage";
        health = 100;
        strength = 30;
        defense = 0.3;
        agility = 0.2;
        isBoss = 0;
        inventory = null;
    }

}
