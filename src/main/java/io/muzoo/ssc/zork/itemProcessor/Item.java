package io.muzoo.ssc.zork.itemProcessor;

public class Item { // Blueprint for Items (weapons, consumables, etc...)

    public int itemType; // 0 for weapon, 1 for consumables (type health), 2 for consumable (type defense)
    public String name;
    public String description;
    public int buffs; // Benefits to the target (used for consumables)
    public int debuffs; // Drawbacks to the target (used for weapons, or consumable weapons (eg. grenades))

}
