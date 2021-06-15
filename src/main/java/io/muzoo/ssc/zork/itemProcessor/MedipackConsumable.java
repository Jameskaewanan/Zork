package io.muzoo.ssc.zork.itemProcessor;

public class MedipackConsumable extends Item{

    public MedipackConsumable() {

        itemType = 1;
        name = "Medipack";
        description = "A Medical pack, restores 20 points of health";
        buffs = 20;
        debuffs = 0;

    }
}
