package io.muzoo.ssc.zork;

import io.muzoo.ssc.zork.commandProcessor.Command;
import io.muzoo.ssc.zork.commandProcessor.CommandFactory;
import io.muzoo.ssc.zork.commandProcessor.CommandHandler;

import java.util.Arrays;
import java.util.Scanner;

public class Game {

    public GameOutput output = new GameOutput();
    private CommandHandler handler = new CommandHandler();
    private CommandFactory factory = new CommandFactory();

    private String[] menuCommands = {"help", "play", "load", "exit"};
    private String[] gameCommands = {"help", "info", "take", "drop", "attack", "go", "map", "autopilot", "quit", "save"};

    public static int isGameRunning = 0;
    public static int quitGame = 0;

    public static String currentRoom;

    public void main_loop() {



        factory.RegisteredCommands(this);

        output.welcomeScreen();

        while (true) {

            if (isGameRunning == 1)
                game_loop();

            Scanner scanner = new Scanner(System.in);
            System.out.print(">> ");
            String playerInput = scanner.nextLine().toLowerCase();
            String[] words = handler.parse(playerInput);

            if (Arrays.asList(menuCommands).contains(words[0])) {
                Command command = factory.lookupExecute(words);
                command.execute(this, words);
            } else {
                System.out.println();
                System.out.println("Invalid Command");
                System.out.println();
            }
        }
    }

    public void game_loop() {

        factory.RegisteredCommands(this);

        output.mapIntro();

        while (true) {

            if (quitGame == 1)
                return;

            Scanner scanner = new Scanner(System.in);
            System.out.print(">> ");
            String playerInput = scanner.nextLine().toLowerCase();
            String[] words = handler.parse(playerInput);

            if (Arrays.asList(gameCommands).contains(words[0])) {
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
