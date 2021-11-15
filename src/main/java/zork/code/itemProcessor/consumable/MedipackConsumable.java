package zork.code.itemProcessor.consumable;

import zork.code.itemProcessor.Item;

public class MedipackConsumable extends Item {

    public MedipackConsumable() {

        itemType = 1;
        name = "Medipack";
        description = "A Medical pack, restores 20 points of health";
        buffs = 20;
        debuffs = 0;

    }
}
