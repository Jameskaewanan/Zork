package zork.code.itemProcessor.weapon;

import zork.code.itemProcessor.Item;

public class KnifeWeapon extends Item {

    public KnifeWeapon() {

        itemType = 0;
        name = "Knife";
        description = "A standard issue combat knife, deals 20 points of damage";
        buffs = 0;
        debuffs = 20;

    }

}
