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
        System.out.println("\n============================================================================================\n");

        System.out.println("[ Player Summary ]\n"); // Display Player Stats
        System.out.println("Name: " + Game.player.name);
        System.out.println("Gender: " + Game.player.gender);
        System.out.println("Race: " + Game.player.race);
        System.out.println("Class: " + Game.player.playerClass);

        //  Test to see if stats are applied correctly
        System.out.print("\nLight Armour: " + Game.player.lightArmour + " | ");
        System.out.print("Handguns: " + Game.player.handguns + " | ");
        System.out.print("Melee: " + Game.player.melee + " | ");
        System.out.print("Speech Craft: " + Game.player.speechcraft + "\n");

        System.out.print("Hacking: " + Game.player.hacking + " | ");
        System.out.print("Crafting: " + Game.player.crafting + " | ");
        System.out.print("First Aid: " + Game.player.firstAid + " | ");
        System.out.print("Marksmanship: " + Game.player.marksmanship + "\n");

        System.out.print("Heavy Armour: " + Game.player.heavyArmour + " | ");
        System.out.print("Heavy Weapons: " + Game.player.heavyWeapons + " | ");
        System.out.print("Athletics: " + Game.player.athletics + " | ");
        System.out.print("Unarmed: " + Game.player.unarmed + "\n");
    }

}
