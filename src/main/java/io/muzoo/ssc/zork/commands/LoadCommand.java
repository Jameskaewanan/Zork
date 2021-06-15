package io.muzoo.ssc.zork.commands;

import io.muzoo.ssc.zork.Game;
import io.muzoo.ssc.zork.commandProcessor.Command;
import io.muzoo.ssc.zork.commandProcessor.CommandFactory;
import io.muzoo.ssc.zork.commandProcessor.CommandHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class LoadCommand extends Command {

    public Game game;

    public LoadCommand (Game game) { this.game = game; }

    @Override
    public String description() {
        return "[ load ] Load the previous save file";
    }

    @Override
    public void execute(Game game, String[] array) throws FileNotFoundException {

        /*

        [ Disclaimer ]

        The "load" command doesn't work yet
        You can save yes, but the save file will be useless
        Something's wrong with the call to command.execute(), idk tbh
        I'll try to fix it in the future, probably an easy fix, but I'm too lazy rn

         */

        CommandHandler handler = new CommandHandler();
        CommandFactory factory = new CommandFactory();

        try {
            String filePath = "C:\\Users\\USER\\Desktop\\zorkSave.txt";
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {

                String cmd = scanner.nextLine();

                System.out.println(cmd);

                String[] words = handler.parse(cmd);
                Command command = factory.lookupExecute(words);

                command.execute(game, words);

            }

            scanner.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("\nSave file not found\n");
            return;
        }




    }
}
