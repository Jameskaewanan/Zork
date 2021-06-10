package io.muzoo.ssc.zork.entityProcesser;

import io.muzoo.ssc.zork.mapProcessor.GenerateRooms;

public class GenerateMonster {

    private static GenerateRooms generateRooms = new GenerateRooms();

    public static Entity createMonster(String monster) {

        if (monster.equals("Parasite")) {
            Entity parasite = new Parasite();
            return parasite;
        }
        if (monster.equals("Infected")) {
            Entity infected = new Infected();
            return infected;
        }
        else {
            return null;
        }
    }

}
