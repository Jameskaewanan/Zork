package io.muzoo.ssc.zork.itemProcessor;

import io.muzoo.ssc.zork.entityProcesser.Entity;
import io.muzoo.ssc.zork.entityProcesser.Parasite;
import io.muzoo.ssc.zork.mapProcessor.GenerateRooms;

public class GenerateItem {

    private static GenerateRooms generateRooms = new GenerateRooms();

    public static Item createItem(String item) {

        if (item.equals("Knife")) {
            Item knife = new KnifeWeapon();
            return knife;
        }
        if (item.equals("MedKit")) {
            Item medkit = new MedKitConsumable();
            return medkit;
        }
        return null;
    }

}
