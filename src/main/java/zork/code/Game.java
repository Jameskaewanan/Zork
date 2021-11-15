package zork.code;

import zork.code.commandProcessor.Command;
import zork.code.commandProcessor.CommandFactory;
import zork.code.commandProcessor.CommandHandler;
import zork.code.entityProcesser.Player;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Game { // Main class to handle game functions

    public GameOutput output = new GameOutput();
    private CommandHandler handler = new CommandHandler();
    private CommandFactory factory = new CommandFactory();

    private String[] menuCommands = {"help", "play", "load", "exit", "load"};
    private String[] gameCommands = {"help", "info", "take", "drop", "attack", "go", "map", "quit", "save", "use", "save"};
    private String[] combatCommands = {"attack", "use", "help", "info"};
    public static ArrayList<String> saveList = new ArrayList<String>();

    public static int isGameRunning = 0;
    public static int quitGame = 0;
    public static int isCombat = 0;
    public static int win = 0;

    public static Player player = new Player();

    public static String currentRoom;

    // ================================================================================================================

    /*
    public static void clearScreen() {
        for(int i = 0; i < 20; i++)
        {
            System.out.println("\b");
        }
    }
     */

    private void PlayerInput(String[] menuCommands) throws FileNotFoundException {
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

    public void main_loop() throws FileNotFoundException { // Main loop managing menu screen

        factory.RegisteredCommands(this);

        output.welcomeScreen();

        while (true) {

            if (isGameRunning == 1) { // Check if "play" command has activated a game session, then switch over to game_loop
                game_loop();
                isGameRunning = 0;
            }

            PlayerInput(menuCommands);
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

            PlayerInput(gameCommands);
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
                        command.execute(this, words);
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

    public void exit() {
        System.exit(0);
    }
}
