package io.muzoo.ssc.zork.itemProcessor;

import io.muzoo.ssc.zork.mapProcessor.GenerateRooms;

public class GenerateItem {

    private static GenerateRooms generateRooms = new GenerateRooms();

    public static Item createItem(String item) {

        if (item.equals("Knife")) {
            Item knife = new KnifeWeapon();
            return knife;
        }
        if (item.equals("Lasrifle")) {
            Item lasrifle = new LasrifleWeapon();
            return lasrifle;
        }
        if (item.equals("Chainsword")) {
            Item chainsword = new ChainSwordWeapon();
            return chainsword;
        }
        if (item.equals("Medipack")) {
            Item medkit = new MedipackConsumable();
            return medkit;
        }
        if (item.equals("Armour")) {
            Item armour = new ArmourConsumable();
            return armour;
        }
        return null;
    }

}
