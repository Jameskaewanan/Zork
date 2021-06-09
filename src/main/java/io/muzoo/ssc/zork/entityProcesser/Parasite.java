package io.muzoo.ssc.zork.entityProcesser;

public class Parasite extends Entity {

    public Parasite() {
        name = "Parasite";
        healthPoints = 20;
        maxHealthPoints = 20;
        attackPoints = 5;
        defensePoints = 0;
    }

    public Parasite(int healthPoints, int attackPoints, int defensePoints) {
        this.healthPoints = healthPoints;
        this.attackPoints = attackPoints;
        this.defensePoints =defensePoints;
    }

}
