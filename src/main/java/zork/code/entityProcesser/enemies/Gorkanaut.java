package zork.code.entityProcesser.enemies;

import zork.code.entityProcesser.Entity;

public class Gorkanaut extends Entity {

    public Gorkanaut() {
        name = "Gorkanaut";
        description = "Massive, tough, loud, and destructive. Iron cladded, an absolute unit. All Orks aspire to be a Gorkanaut";
        health = 200;
        strength = 100;
        defense = 0.7;
        agility = 0;
        isBoss = 1;
        inventory = null;
    }

}
