package io.muzoo.ssc.zork;

import io.muzoo.ssc.zork.commandProcessor.Command;
import io.muzoo.ssc.zork.commandProcessor.CommandFactory;
import io.muzoo.ssc.zork.commandProcessor.CommandHandler;
import io.muzoo.ssc.zork.entityProcesser.Player;
import io.muzoo.ssc.zork.itemProcessor.FistWeapon;
import io.muzoo.ssc.zork.itemProcessor.Item;
import io.muzoo.ssc.zork.mapProcessor.GenerateMap;
import io.muzoo.ssc.zork.mapProcessor.Room;

import java.util.Arrays;
import java.util.Scanner;

public class Game { // Main class to handle game functions

    public GameOutput output = new GameOutput();
    private CommandHandler handler = new CommandHandler();
    private CommandFactory factory = new CommandFactory();

    private String[] menuCommands = {"help", "play", "load", "exit"};
    private String[] gameCommands = {"help", "info", "take", "drop", "attack", "go", "map", "quit", "save", "use"};
    private String[] combatCommands = {"attack", "use", "help", "info"};

    public static int isGameRunning = 0;
    public static int quitGame = 0;
    public static int isCombat = 0;

    public static Player player = new Player();

    public static String currentRoom;

    public void main_loop() { // Main loop managing menu screen

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
            String[] words = handler.parse(playerInput);

            if (Arrays.asList(menuCommands).contains(words[0])) { // Parse command and check if valid command
                Command command = factory.lookupExecute(words);
                command.execute(this, words);
            } else {
                System.out.println("\nInvalid Command\n");
            }
        }
    }

    public void game_loop() { // Loop that runs the game session

        factory.RegisteredCommands(this);

        output.mapIntro();

        while (isGameRunning == 1) {

            if (isCombat == 1) {
                combat_loop();
            }

            if (isGameRunning == 0) // Addresses a bug where once player dies, game does not quit session properly
                break;

            Scanner scanner = new Scanner(System.in);
            System.out.print(">> ");
            String playerInput = scanner.nextLine().toLowerCase();
            String[] words = handler.parse(playerInput);

            if (Arrays.asList(gameCommands).contains(words[0])) { // Parse command and check if valid command
                Command command = factory.lookupExecute(words);
                command.execute(this, words);
            } else {
                System.out.println("\nInvalid Command\n");
            }
        }

    }

    public void combat_loop() { // Loop that handles combat

        while (isCombat == 1) {

            output.displayCombat();

            Scanner scanner = new Scanner(System.in);
            System.out.print(">> ");
            String playerInput = scanner.nextLine().toLowerCase();
            String[] words = handler.parse(playerInput);

            if (Arrays.asList(combatCommands).contains(words[0])) { // Parse command and check if valid command
                Command command = factory.lookupExecute(words);

                if (words[0].equals("attack")) { // Case of attacking
                    if (words.length < 3)
                        System.out.println("\nPlease input attack command in the format of [ attack with <weapon> ]\n");
                    else {
                        combatLogic(words[0], words[2]);
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

    public void combatLogic(String command, String item) {

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
            System.out.println("\nEquipped " + weapon.name);
        }
        else if (player.inventory.containsKey(item) && player.inventory.get(item).itemType == 1) {
            System.out.println(player.inventory.get(item).name + " is not a weapon\n");
            System.out.println("\nWill default to using fists");
        }
        else if (!player.inventory.containsKey(item)) {
            System.out.println("\nWeapon does not exist in inventory");
            System.out.println("\nWill default to using fists");
        }

        int playerDamage = Game.player.attackPoints + weapon.debuffs;

        for (Room room : GenerateMap.roomList) {
            if (currentRoom.equals(room.name)) {
                if (room.monster != null){

                    System.out.println("\n" + "Attacking " + room.monster.name + " with " + weapon.name);

                    room.monster.healthPoints = room.monster.healthPoints - (playerDamage);
                    System.out.println("\n" + "Dealt " + playerDamage + " Damage to " + room.monster.name);

                    Game.player.healthPoints = Game.player.healthPoints - room.monster.attackPoints;

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
