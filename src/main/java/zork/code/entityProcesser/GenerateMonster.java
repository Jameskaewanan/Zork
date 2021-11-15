package zork.code.entityProcesser;

import zork.code.entityProcesser.enemies.Boyz;
import zork.code.entityProcesser.enemies.Gorkanaut;
import zork.code.entityProcesser.enemies.Gretchin;
import zork.code.mapProcessor.GenerateRooms;

public class GenerateMonster {

    private static GenerateRooms generateRooms = new GenerateRooms();

    public static Entity createMonster(String monster) {

        if (monster.equals("Gretchin")) {
            Entity gretchin = new Gretchin();
            return gretchin;
        }
        if (monster.equals("Boyz")) {
            Entity boyz = new Boyz();
            return boyz;
        }
        if (monster.equals("Gorkanaut")) {
            Entity gorkanaut = new Gorkanaut();
            return gorkanaut;
        }
        else {
            return null;
        }
    }

}
