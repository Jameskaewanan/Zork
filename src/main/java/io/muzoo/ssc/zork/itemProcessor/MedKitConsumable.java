package io.muzoo.ssc.zork.itemProcessor;

public class MedKitConsumable extends Item{

    public MedKitConsumable() {

        itemType = 1;
        name = "MedKit";
        description = "A Medkit, restores 20 points of health";
        buffs = 20;
        debuffs = 0;

    }
}
