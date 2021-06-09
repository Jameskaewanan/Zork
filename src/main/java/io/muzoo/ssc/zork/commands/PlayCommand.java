package io.muzoo.ssc.zork.commands;

import io.muzoo.ssc.zork.Game;
import io.muzoo.ssc.zork.commandProcessor.Command;
import io.muzoo.ssc.zork.mapProcessor.GenerateMap;

import java.io.FileNotFoundException;

public class PlayCommand extends Command { // Command to indicate that a game session has started

    private Game game;
    public static String[] array;
    GenerateMap generateMap = new GenerateMap();

    public PlayCommand(Game game) {
        this.game = game;
    }

    @Override
    public String description() {
        return "[ play <map-name> ] Initializes the chosen map and starts the game. Available maps: Spaceship";
    }

    @Override
    public void execute(Game game, String[] array){

        this.array = array;

        if (array.length <= 1) { // Check if argument for a chosen map exists
            System.out.println();
            System.out.println("Please input a map. Available maps: Spaceship");
            System.out.println();
            return;
        }

        try { // If chosen map is available generate the map
            generateMap.map(array);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
