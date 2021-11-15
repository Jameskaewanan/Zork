package zork.code.commands;

import zork.code.Game;
import zork.code.GameOutput;
import zork.code.commandProcessor.Command;
import zork.code.itemProcessor.weapon.FistWeapon;
import zork.code.itemProcessor.Item;
import zork.code.mapProcessor.GenerateMap;
import zork.code.mapProcessor.Room;

import java.util.Random;

public class AttackCommand extends Command {

    private Game game;

    public AttackCommand(Game game) { this.game = game; }

    @Override
    public String description() {
        return "[ attack with <weapon> ] attack monster with specified weapon";
    }

    @Override
    public void execute(Game game, String[] array) {

        if (array.length < 3) {
            System.out.println("\nPlease input attack command in the format of [ attack with <weapon> ]\n");
            return;
        }

        String item = array[2];

        for (Room room : GenerateMap.roomList) {
            if (Game.currentRoom.equals(room.name)) {
                if (room.monster == null) {
                    System.out.println("\nNo monsters in the area\n");
                    return;
                }
            }
        }

        Game.isCombat = 1; // Activate combat sequence

        // ################################## COMBAT LOGIC ##################################

        Item weapon = new FistWeapon();
        String currentRoom = Game.currentRoom;

        // Check if weapon exists in inventory

        if (item.equals("fist") || item.equals("fists")){
            System.out.println("\nEquipped fists");
        }
        else if (Game.player.inventory.size() == 0) {
            System.out.println("\nNothing in inventory, will default to using fists");
        }
        else if (Game.player.inventory.containsKey(item) && Game.player.inventory.get(item).itemType == 0) {
            weapon = Game.player.inventory.get(item);
        }
        else if (Game.player.inventory.containsKey(item) && Game.player.inventory.get(item).itemType == 1) {
            System.out.println(Game.player.inventory.get(item).name + " is not a weapon, will default to using fists");
        }
        else if (!Game.player.inventory.containsKey(item)) {
            System.out.println("\nWeapon does not exist in inventory, will default to using fists");
        }

        for (Room room : GenerateMap.roomList) {
            if (currentRoom.equals(room.name)) {
                if (room.monster != null){

                    // ######### Damage Logic #########

                    Random rand = new Random();

                    // PLAYER DAMAGE AND HIT CHANCE LOGIC

                    int maxPlayerAttack = (int) (weapon.debuffs - (weapon.debuffs * room.monster.defense));
                    double playerDamageMultiplier = (2 * Game.player.strength);

                    if (playerDamageMultiplier < 1) {
                        maxPlayerAttack = (int) (maxPlayerAttack * (1 + playerDamageMultiplier));
                    }
                    else if (playerDamageMultiplier >= 1) {
                        maxPlayerAttack = (int) (maxPlayerAttack * playerDamageMultiplier);
                    }

                    int minPlayerAttack = (int) (0.7 * maxPlayerAttack);
                    int playerAttack = (int) (minPlayerAttack + (maxPlayerAttack - minPlayerAttack) * rand.nextDouble());

                    double playerHitChance = (1-room.monster.agility);
                    if (playerHitChance < 0.4) { // 0.4 base hit chance, Always have at least a 40% chance to hit
                        playerHitChance = playerHitChance + 0.4;
                    }

                    int random100 = rand.nextInt(100 - 0 + 1) + 0;
                    if (random100 >= playerHitChance*100) {
                        System.out.println("\nYou missed");
                    }
                    else {
                        System.out.println("\n" + "Attacking " + room.monster.name + " with " + weapon.name);
                        room.monster.health = room.monster.health - (playerAttack);
                        System.out.println("\n" + "You Dealt " + playerAttack + " Damage to " + room.monster.name);
                    }

                    // MONSTER DAMAGE AND HIT CHANCE LOGIC

                    int maxMonsterAttack = (int) (room.monster.strength - (room.monster.strength * Game.player.defense));
                    int minMonsterAttack = (int) (0.7 * maxMonsterAttack);
                    int monsterAttack = (int) (minMonsterAttack + (maxMonsterAttack - minMonsterAttack) * rand.nextDouble());

                    double monsterHitChance = (1-Game.player.agility);
                    if (monsterHitChance < 0.4) { // 0.4 base hit chance, Always have at least a 40% chance to hit
                        monsterHitChance = monsterHitChance + 0.4;
                    }

                    random100 = rand.nextInt(100 - 0 + 1) + 0;

                    if (random100 >= monsterHitChance*100) {
                        System.out.println("\n" + room.monster.name + " missed");
                    }
                    else {
                        System.out.println("\n" + room.monster.name + " attacked you");
                        Game.player.health = Game.player.health - (monsterAttack);
                        System.out.println("\n" + room.monster.name + " Dealt " + monsterAttack + " Damage to you");
                    }

                    // ######### End of Damage Logic #########

                    if (room.monster.health <= 0 && room.monster.isBoss == 1) {
                        System.out.println("\n" + room.monster.name + " Defeated");
                        room.monster = null;
                        Game.isCombat = 0;
                        Game.isGameRunning = 0;
                        Game.win = 1;
                        return;
                    }

                    if (room.monster.health <= 0) {
                        System.out.println("\n" + room.monster.name + " Defeated");
                        room.monster = null;
                        Game.isCombat = 0;
                        return;
                    }

                    if (Game.player.health <= 0) {
                        System.out.println("\nYou are dead, no big surprise\n");
                        Game.isCombat = 0;
                        Game.isGameRunning = 0;
                        GameOutput.welcomeScreen();
                        return;
                    }
                }
            }
        }

        // ################################## END OF COMBAT LOGIC ##################################
    }
}
