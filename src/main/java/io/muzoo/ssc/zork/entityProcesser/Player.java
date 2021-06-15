package io.muzoo.ssc.zork.entityProcesser;

import io.muzoo.ssc.zork.itemProcessor.Item;

import java.util.ArrayList;
import java.util.HashMap;

public class Player extends Entity{

    public Player() {
        name = "Player";
        healthPoints = 100;
        maxHealthPoints = 200;
        attackPoints = 0;
        defensePoints = 0.1;
        agilityPoints = 0;
        isBoss = 0;
        inventory = new HashMap<String, Item>();
    }

}
