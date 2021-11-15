package zork.code.entityProcesser.enemies;

import zork.code.entityProcesser.Entity;

public class Gretchin extends Entity {

    public Gretchin() {
        name = "Gretchin";
        description = "Feeble and cowardly, these goblin like creatures deals minuscule amounts damage but can be deadly in larger numbers";
        health = 20;
        strength = 10;
        defense = 0.1;
        agility = 0.3;
        isBoss = 0;
        inventory = null;
    }

}
