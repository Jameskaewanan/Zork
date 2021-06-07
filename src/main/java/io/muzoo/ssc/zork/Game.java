import java.util.Scanner;

public class Game {




    Scanner scanner = new Scanner(System.in);


    public void game_loop() {
        while (true) {

            System.out.print(">> ");
            String playerInput = scanner.nextLine();

            System.out.println(playerInput);
        }
    }

}
