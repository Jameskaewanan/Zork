package io.muzoo.ssc.zork;

import io.muzoo.ssc.zork.commandProcessor.Command;
import io.muzoo.ssc.zork.commandProcessor.CommandFactory;
import io.muzoo.ssc.zork.commandProcessor.CommandHandler;
import io.muzoo.ssc.zork.entityProcesser.Player;

import java.util.Arrays;
import java.util.Scanner;

public class Game { // Main class to handle game functions

    public GameOutput output = new GameOutput();
    private CommandHandler handler = new CommandHandler();
    private CommandFactory factory = new CommandFactory();

    private String[] menuCommands = {"help", "play", "load", "exit"};
    private String[] gameCommands = {"help", "info", "take", "drop", "attack", "go", "map", "autopilot", "quit", "save"};

    public static int isGameRunning = 0;
    public static int quitGame = 0;

    public static Player player = new Player();

    public static String currentRoom;

    public void main_loop() { // Main loop managing menu screen

        factory.RegisteredCommands(this);

        output.welcomeScreen();

        while (true) {

            if (isGameRunning == 1) { // Check if "play" command has activated a game session, then switch over to game_loop
                game_loop();
                quitGame = 0;
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
                System.out.println();
                System.out.println("Invalid Command");
                System.out.println();
            }
        }
    }

    public void game_loop() { // Loop that runs the game session

        factory.RegisteredCommands(this);

        output.mapIntro();

        while (true) {

            if (quitGame == 1) // Check if "quit" command has activated quit, then return back to main_loop
                return;

            Scanner scanner = new Scanner(System.in);
            System.out.print(">> ");
            String playerInput = scanner.nextLine().toLowerCase();
            String[] words = handler.parse(playerInput);

            if (Arrays.asList(gameCommands).contains(words[0])) { // Parse command and check if valid command
                Command command = factory.lookupExecute(words);
                command.execute(this, words);
            } else {
                System.out.println();
                System.out.println("Invalid Command");
                System.out.println();
            }

        }

    }

    public void exit() {
        System.exit(0);
    }
}
