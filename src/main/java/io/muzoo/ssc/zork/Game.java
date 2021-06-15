package io.muzoo.ssc.zork;

import io.muzoo.ssc.zork.commandProcessor.Command;
import io.muzoo.ssc.zork.commandProcessor.CommandFactory;
import io.muzoo.ssc.zork.commandProcessor.CommandHandler;
import io.muzoo.ssc.zork.entityProcesser.Player;
import io.muzoo.ssc.zork.itemProcessor.FistWeapon;
import io.muzoo.ssc.zork.itemProcessor.Item;
import io.muzoo.ssc.zork.mapProcessor.GenerateMap;
import io.muzoo.ssc.zork.mapProcessor.Room;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game { // Main class to handle game functions

    public GameOutput output = new GameOutput();
    private CommandHandler handler = new CommandHandler();
    private CommandFactory factory = new CommandFactory();

    private String[] menuCommands = {"help", "play", "load", "exit", "load"};
    private String[] gameCommands = {"help", "info", "take", "drop", "attack", "go", "map", "quit", "save", "use", "save"};
    private String[] combatCommands = {"attack", "use", "help", "info"};
    public ArrayList<String> saveList = new ArrayList<String>();

    public static int isGameRunning = 0;
    public static int quitGame = 0;
    public static int isCombat = 0;
    public static int win = 0;

    public static Player player = new Player();

    public static String currentRoom;

    public void main_loop() throws FileNotFoundException { // Main loop managing menu screen

        factory.RegisteredCommands(this);

        output.welcomeScreen();

        while (true) {

            if (isGameRunning == 1) { // Check if "play" command has activated a game session, then switch over to game_loop
                game_loop();
                isGameRunning = 0;
            }

            Scanner scanner = new Scanner(System.in);
            System.out.print(">> ");
            String playerInput = scanner.nextLine().toLowerCase();
            saveList.add(playerInput);
            String[] words = handler.parse(playerInput);

            if (Arrays.asList(menuCommands).contains(words[0])) { // Parse command and check if valid command
                Command command = factory.lookupExecute(words);
                command.execute(this, words);
            } else {
                System.out.println("\nInvalid Command\n");
            }
        }
    }

    public void game_loop() throws FileNotFoundException { // Loop that runs the game session

        factory.RegisteredCommands(this);

        output.mapIntro();

        while (isGameRunning == 1) {

            if (isCombat == 1) {
                combat_loop();
            }

            if (isGameRunning == 0) // Addresses a bug where once player dies, game does not quit session properly
                break;

            if (win == 1) {
                output.displayEnding();
                return;
            }

            Scanner scanner = new Scanner(System.in);
            System.out.print(">> ");
            String playerInput = scanner.nextLine().toLowerCase();
            saveList.add(playerInput);
            String[] words = handler.parse(playerInput);

            if (Arrays.asList(gameCommands).contains(words[0])) { // Parse command and check if valid command
                Command command = factory.lookupExecute(words);
                command.execute(this, words);
            } else {
                System.out.println("\nInvalid Command\n");
            }
        }

    }

    public void combat_loop() throws FileNotFoundException { // Loop that handles combat

        while (isCombat == 1) {

            output.displayCombat();

            Scanner scanner = new Scanner(System.in);
            System.out.print(">> ");
            String playerInput = scanner.nextLine().toLowerCase();
            saveList.add(playerInput);
            String[] words = handler.parse(playerInput);

            if (Arrays.asList(combatCommands).contains(words[0])) { // Parse command and check if valid command
                Command command = factory.lookupExecute(words);

                if (words[0].equals("attack")) { // Case of attacking
                    if (words.length < 3)
                        System.out.println("\nPlease input attack command in the format of [ attack with <weapon> ]\n");
                    else {
                        combatLogic(words[2]);
                    }
                }

                else {
                    command.execute(this, words); // For other commands such as "help"
                }
            }
            else {
                System.out.println("\nInvalid Command\n");
            }
        }
    }

    public void combatLogic(String item) {

        Item weapon = new FistWeapon();
        String currentRoom = Game.currentRoom;

        // Check if weapon exists in inventory

        if (item.equals("fist") || item.equals("fists")){
            System.out.println("\nEquipped fists");
        }
        else if (Game.player.inventory.size() == 0) {
            System.out.println("\nNothing in inventory, will default to using fists");
        }
        else if (player.inventory.containsKey(item) && player.inventory.get(item).itemType == 0) {
            weapon = player.inventory.get(item);
        }
        else if (player.inventory.containsKey(item) && player.inventory.get(item).itemType == 1) {
            System.out.println(player.inventory.get(item).name + " is not a weapon, will default to using fists");
        }
        else if (!player.inventory.containsKey(item)) {
            System.out.println("\nWeapon does not exist in inventory, will default to using fists");
        }

        for (Room room : GenerateMap.roomList) {
            if (currentRoom.equals(room.name)) {
                if (room.monster != null){

                    // ######### Damage Logic #########

                    Random rand = new Random();

                    // PLAYER DAMAGE AND HIT CHANCE LOGIC

                    int maxPlayerAttack = (int) (weapon.debuffs - (weapon.debuffs * room.monster.defensePoints));
                    int minPlayerAttack = (int) (0.7 * maxPlayerAttack);
                    int playerAttack = (int) (minPlayerAttack + (maxPlayerAttack - minPlayerAttack) * rand.nextDouble());

                    double playerHitChance = (1-room.monster.agilityPoints);
                    if (playerHitChance < 0.4) { // 0.4 base hit chance, Always have at least a 40% chance to hit
                        playerHitChance = playerHitChance + 0.4;
                    }

                    int random100 = rand.nextInt(100 - 0 + 1) + 0;
                    if (random100 >= playerHitChance*100) {
                        System.out.println("\nYou missed");
                    }
                    else {
                        System.out.println("\n" + "Attacking " + room.monster.name + " with " + weapon.name);
                        room.monster.healthPoints = room.monster.healthPoints - (playerAttack);
                        System.out.println("\n" + "You Dealt " + playerAttack + " Damage to " + room.monster.name);
                    }

                    // MONSTER DAMAGE AND HIT CHANCE LOGIC

                    int maxMonsterAttack = (int) (room.monster.attackPoints - (room.monster.attackPoints * player.defensePoints));
                    int minMonsterAttack = (int) (0.7 * maxMonsterAttack);
                    int monsterAttack = (int) (minMonsterAttack + (maxMonsterAttack - minMonsterAttack) * rand.nextDouble());

                    double monsterHitChance = (1-player.agilityPoints);
                    if (monsterHitChance < 0.4) { // 0.4 base hit chance, Always have at least a 40% chance to hit
                        monsterHitChance = monsterHitChance + 0.4;
                    }

                    random100 = rand.nextInt(100 - 0 + 1) + 0;

                    if (random100 >= monsterHitChance*100) {
                        System.out.println("\n" + room.monster.name + " missed");
                    }
                    else {
                        System.out.println("\n" + room.monster.name + " attacked you");
                        player.healthPoints = player.healthPoints - (monsterAttack);
                        System.out.println("\n" + room.monster.name + " Dealt " + monsterAttack + " Damage to you");
                    }

                    // ######### End of Damage Logic #########

                    if (room.monster.healthPoints <= 0 && room.monster.isBoss == 1) {
                        System.out.println("\n" + room.monster.name + " Defeated");
                        System.out.println("\nExiting combat sequence\n");
                        room.monster = null;
                        isCombat = 0;
                        isGameRunning = 0;
                        win = 1;
                        return;
                    }

                    if (room.monster.healthPoints <= 0) {
                        System.out.println("\n" + room.monster.name + " Defeated");
                        System.out.println("\nExiting combat sequence\n");
                        room.monster = null;
                        isCombat = 0;
                        return;
                    }

                    if (Game.player.healthPoints <= 0) {
                        System.out.println("\nYou are dead, no big surprise\n");
                        isCombat = 0;
                        isGameRunning = 0;
                        output.welcomeScreen();
                        return;
                    }
                }
            }
        }
    }

    public void exit() {
        System.exit(0);
    }
}
