package zork.code.itemProcessor.consumable;

import zork.code.itemProcessor.Item;

public class ArmourConsumable extends Item {

    public ArmourConsumable() {

        itemType = 2;
        name = "Armour";
        description = "A standard issue piece of flak armour, provides little protection";
        buffs = 20;
        debuffs = 0;

    }

}
