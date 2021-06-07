package io.muzoo.ssc.zork;

import io.muzoo.ssc.zork.commandProcessor.Command;
import io.muzoo.ssc.zork.commandProcessor.CommandFactory;
import io.muzoo.ssc.zork.commandProcessor.CommandHandler;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {

    public GameOutput output = new GameOutput();
    private CommandHandler handler = new CommandHandler();
    private CommandFactory factory = new CommandFactory();

    public void game_loop() {

        factory.RegisteredCommands(this);

        output.welcomeScreen();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print(">> ");
            String playerInput = scanner.nextLine();
            String[] words = handler.parse(playerInput);
            //output.println(playerInput);
            Command command = factory.lookupExecute(words);

            command.execute(this, words);
            // testing stuff below

         /*
            if (words[1].equals("hello"))
                System.out.println("1");
            else
                System.out.println("0");
        */

        }
    }

    public void exit() {
        System.exit(0);
    }
}
