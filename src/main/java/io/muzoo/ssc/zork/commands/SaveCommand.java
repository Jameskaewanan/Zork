package io.muzoo.ssc.zork.commands;

import io.muzoo.ssc.zork.Game;
import io.muzoo.ssc.zork.commandProcessor.Command;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

public class SaveCommand extends Command {

    private Game game;

    public SaveCommand(Game game) {
        this.game = game;
    }

    @Override
    public String description() {
        return "[ save ] Saves the current state of the game";
    }

    @Override
    public void execute(Game game, String[] array) throws FileNotFoundException {

        game.saveList.remove(game.saveList.size()-1);

        try(FileOutputStream output = new FileOutputStream("zorkSave.txt")){

            Iterator<String> iter = game.saveList.iterator();
            PrintWriter print = new PrintWriter(output, true);

            while (iter.hasNext()) {
                String command = iter.next();
                print.println(command);
            }

            print.close();

            System.out.println("\nSave Successful\n");
        }
        catch (IOException e) {
            System.err.println(e);
            return;
        }

    }
}
