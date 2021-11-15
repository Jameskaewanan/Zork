package zork.code;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException { // Launch game
        Game game = new Game();
        game.main_loop();
    }

}
