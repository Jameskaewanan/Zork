package zork.code.characterCreation;

import zork.code.Game;
import zork.code.mapProcessor.GenerateRooms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomizationOutput {
    CharacterCreation characterCreation = new CharacterCreation();

    public static void RaceOutput(String race) throws FileNotFoundException {

        int counter = 4;
        String next;

        ArrayList<String> output = new ArrayList<String>();

        String filePath = "src/main/java/zork/code/characterCreation/customizationInfo/Races";
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {

            String raceName = scanner.nextLine();

            if (raceName.equals(race)) {
                output.add(raceName);
                while (counter != 0) {
                    next = scanner.nextLine();
                    output.add(next);
                    counter -= 1;
                }
            }
        }

        System.out.println();
        for (String line : output) {
            System.out.println(line);
        }
        System.out.println();
    }

    public static void ClassOutput(String class_) throws FileNotFoundException {

        int counter = 2;
        String next;

        ArrayList<String> output = new ArrayList<String>();

        String filePath = "src/main/java/zork/code/characterCreation/customizationInfo/Classes";
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {

            String className = scanner.nextLine();

            if (className.equals(class_)) {
                output.add(className);
                while (counter != 0) {
                    next = scanner.nextLine();
                    output.add(next);
                    counter -= 1;
                }
            }
        }

        System.out.println();
        for (String line : output) {
            System.out.println(line);
        }
        System.out.println();
    }

    public static void SummaryOutput() {
        System.out.println("============================================================================================\n");

        System.out.println("[ Player Summary ]"); // Display Player Stats
        System.out.println("Name: " + Game.player.name);
        System.out.println("Gender: " + Game.player.gender);
        System.out.println("Race: " + Game.player.race);

        System.out.println("Class: " + Game.player.playerClass);
    }

}
