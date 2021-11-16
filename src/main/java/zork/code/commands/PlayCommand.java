package zork.code.commands;

import zork.code.Game;
import zork.code.characterCreation.CharacterCreation;
import zork.code.commandProcessor.Command;
import zork.code.mapProcessor.GenerateMap;

import java.io.FileNotFoundException;

public class PlayCommand extends Command { // Command to indicate that a game session has started

    private Game game;
    public static String[] array;
    GenerateMap generateMap = new GenerateMap();
    CharacterCreation characterCreation = new CharacterCreation();

    public PlayCommand(Game game) {
        this.game = game;
    }

    @Override
    public String description() {
        return "[ play ] Initializes the map and starts the game.";
    }

    @Override
    public void execute(Game game, String[] array){

        this.array = array;

        if (array.length > 1) { // Check if argument for a chosen map exists
            System.out.println("\nInvalid command\n");
            return;
        }

        try { // Go to character customization and generate map
            while (characterCreation.getCheck() == 0) {
                characterCreation.CustomizationProcess();
            }
            generateMap.map();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
