package zork.code.commands;

import zork.code.Game;
import zork.code.commandProcessor.Command;
import zork.code.commandProcessor.CommandFactory;
import zork.code.commandProcessor.CommandHandler;

import java.io.File;
import java.io.FileNotFoundException;
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

        CommandHandler handler = new CommandHandler();
        CommandFactory factory = new CommandFactory();

        try {
            String filePath = Game.player.name + ".txt";
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
