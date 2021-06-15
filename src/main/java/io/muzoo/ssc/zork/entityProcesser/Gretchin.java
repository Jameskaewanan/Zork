package io.muzoo.ssc.zork.entityProcesser;

public class Gretchin extends Entity {

    public Gretchin() {
        name = "Gretchin";
        description = "Feeble and cowardly, these goblin like creatures deals minuscule amounts damage but can be deadly in larger numbers";
        healthPoints = 20;
        maxHealthPoints = 20;
        attackPoints = 10;
        defensePoints = 0.1;
        agilityPoints = 0.3;
        isBoss = 0;
        inventory = null;
    }

}
