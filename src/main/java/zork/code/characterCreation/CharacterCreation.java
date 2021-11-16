package zork.code.characterCreation;

import zork.code.Game;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CharacterCreation {
    int check = 0;
    public static ArrayList<String> saveListCC = new ArrayList<String>();

    private String PlayerInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(">> ");
        String input = scanner.nextLine();
        saveListCC.add(input);
        return input;
    }

    public void CustomizationProcess() throws FileNotFoundException {

        while (check == 0) {

            System.out.println("\nWelcome to the Character Creation process");

            //  ================================== Gender Selection Loop ==================================
            while (true) {
                System.out.println("\nSelect your Gender: [Male | Female]\n");
                String gender = PlayerInput();

                if (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female")) {
                    Game.player.gender = "Male";
                    break;
                }
                if (gender.equalsIgnoreCase("female")) {
                    Game.player.gender = "Female";
                    break;
                }
                else {
                    System.out.println("\nSorry, please input a valid gender\n");
                }
            }

            //  ================================== Race Selection Loop ==================================
            while (true) {
                System.out.println("\nSelect your Race [Human | Onarii | Altherim]\n");
                String race = PlayerInput();

                if (race.equalsIgnoreCase("human")) {
                    CustomizationOutput.RaceOutput("Human");
                    System.out.println("Are you use you want to be a Human? [Yes | No]\n");
                    String confirm = PlayerInput();

                    if (confirm.equalsIgnoreCase("yes")) {
                        setRace("Human", 0.075, 0, 0.3, 0);
                        break;
                    }
                    if (confirm.equalsIgnoreCase("no")) {
                        continue;
                    }
                }
                if (race.equalsIgnoreCase("onarii")) {
                    CustomizationOutput.RaceOutput("Onarii");
                    System.out.println("Are you use you want to be a Onarii? [Yes | No]\n");
                    String confirm = PlayerInput();

                    if (confirm.equalsIgnoreCase("yes")) {
                        setRace("Onarii", 0.075, 0, 0.3, 0);
                        break;
                    }
                    if (confirm.equalsIgnoreCase("no")) {
                        continue;
                    }
                }
                if (race.equalsIgnoreCase("altherim")) {
                    CustomizationOutput.RaceOutput("Altherim");
                    System.out.println("Are you use you want to be a Altherim? [Yes | No]\n");
                    String confirm = PlayerInput();

                    if (confirm.equalsIgnoreCase("yes")) {
                        setRace("Altherim", 0.075, 0, 0.3, 0);
                        break;
                    }
                    if (confirm.equalsIgnoreCase("no")) {
                        continue;
                    }
                }
                else {
                    System.out.println("\nPlease input a valid race");
                }
            }

            //  ================================== Class Selection Loop ==================================
            while (true) {
                System.out.println("\nSelect your Class [Rogue | Specialist | Enforcer]\n");
                String playerClass = PlayerInput();

                if (playerClass.equalsIgnoreCase("rogue")) {
                    CustomizationOutput.ClassOutput("Rogue");
                    System.out.println("Are you use you want to be a Rogue? [Yes | No]\n");
                    String confirm = PlayerInput();

                    if (confirm.equalsIgnoreCase("yes")) {
                        setClassRogue(0.125);
                        Game.player.playerClass = "Rogue";
                        break;
                    }
                    if (confirm.equalsIgnoreCase("no")) {
                        continue;
                    }
                }
                if (playerClass.equalsIgnoreCase("specialist")) {
                    CustomizationOutput.ClassOutput("Specialist");
                    System.out.println("Are you use you want to be a Specialist? [Yes | No]\n");
                    String confirm = PlayerInput();

                    if (confirm.equalsIgnoreCase("yes")) {
                        setClassSpecialist(0.125);
                        Game.player.playerClass = "Specialist";
                        break;
                    }
                    if (confirm.equalsIgnoreCase("no")) {
                        continue;
                    }
                }
                if (playerClass.equalsIgnoreCase("enforcer")) {
                    CustomizationOutput.ClassOutput("Enforcer");
                    System.out.println("Are you use you want to be a Enforcer? [Yes | No]\n");
                    String confirm = PlayerInput();

                    if (confirm.equalsIgnoreCase("yes")) {
                        setClassEnforcer(0.125);
                        Game.player.playerClass = "Enforcer";
                        break;
                    }
                    if (confirm.equalsIgnoreCase("no")) {
                        continue;
                    }
                }
                else {
                    System.out.println("\nPlease input a valid class");
                }
            }

            //  ================================== Name Loop ==================================
            while (true) {
                System.out.println("\nWhat is your name?\n");
                String name = PlayerInput();

                String a []= name.split(" ");
                String output = "";
                for (String s:a){
                    output = output + s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase() + " ";

                }
                name = output;

                System.out.println("\nYour name is " + name + ". Is that correct? [Yes | No]\n");
                String confirm = PlayerInput();

                if (confirm.equalsIgnoreCase("yes")) {
                    Game.player.name = name;
                    break;
                }
                if (confirm.equalsIgnoreCase("no")) {
                    continue;
                }
                else {
                    System.out.println("\nPlease enter either [Yes | No]");
                }
            }

            //  ================================== Summary Loop ==================================
            while (true) {
                CustomizationOutput.SummaryOutput();

                System.out.println("\nIs this correct? [Yes | No]\n");
                String confirm = PlayerInput();

                if (confirm.equalsIgnoreCase("yes")) {
                    check = 1;
                    break;
                }
                if (confirm.equalsIgnoreCase("no")) {
                    break;
                }
                else {
                    System.out.println("\nPlease enter either [Yes | No]\n");
                }
            }
        }

        Game.saveList.addAll(saveListCC);
    }

    // Setting the player's race
    public void setRace(String race, double strength, double agility, double intelligence, double health) {
        Game.player.race = race;

        Game.player.strength += strength;
        Game.player.agility += agility;
        Game.player.intelligence += intelligence;

        Game.player.health += health;
        Game.player.maxHealth += health;
    }

    // Setting the player's Class
    // Shitty implementation but it works so... ¯\_(ツ)_/¯
    public void setClassRogue(double stat) {
        Game.player.lightArmour += stat;
        Game.player.handguns += stat;
        Game.player.melee += stat;
        Game.player.hacking += stat;
    }
    public void setClassSpecialist(double stat) {
        Game.player.hacking += stat;
        Game.player.crafting += stat;
        Game.player.handguns += stat;
        Game.player.marksmanship += stat;
    }
    public void setClassEnforcer(double stat) {
        Game.player.heavyArmour += stat;
        Game.player.heavyWeapons += stat;
        Game.player.firstAid += stat;
        Game.player.unarmed += stat;
    }

    public int getCheck() {
        return check;
    }
}
