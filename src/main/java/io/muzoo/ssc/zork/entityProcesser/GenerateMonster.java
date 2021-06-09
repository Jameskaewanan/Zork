package io.muzoo.ssc.zork.entityProcesser;

import io.muzoo.ssc.zork.mapProcessor.GenerateRooms;

public class GenerateMonster {

    private static GenerateRooms generateRooms = new GenerateRooms();
    public static String monster = generateRooms.getMonster();


    public static Entity createMonster() {

        if (monster.equals("Parasite")) {
            Entity parasite = new Parasite();
            return parasite;
        }
        return null;
    }


}
