package zork.code.characterCreation;

import zork.code.Game;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CharacterCreation {
    int check = 0;
    public static ArrayList<String> saveListCC = new ArrayList<String>();

    private String PlayerInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(">> ");
        String input = scanner.nextLine().toLowerCase();
        saveListCC.add(input);
        return input;
    }

    public void CustomizationProcess() throws FileNotFoundException {
        System.out.println("\nWelcome to the Character Creation process");

        //  ================================== Gender Selection Loop ==================================
        while (true) {
            System.out.println("\nSelect your Gender: [Male | Female]\n");
            String gender = PlayerInput();

            if (gender.equals("male") || gender.equals("female")) {
                Game.player.gender = gender;
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

            if (race.equals("human")) {
                CustomizationOutput.RaceOutput("Human");
                System.out.println("\nAre you use you want to be a Human? [Yes | No]\n");
                String confirm = PlayerInput();

                if (confirm.equals("yes")) {
                    setRace("Human", 0.075, 0, 0.3, 0);
                    break;
                }
                if (confirm.equals("no")) {
                    continue;
                }
            }
            if (race.equals("onarii")) {
                CustomizationOutput.RaceOutput("Onarii");
                System.out.println("\nAre you use you want to be a Onarii? [Yes | No]\n");
                String confirm = PlayerInput();

                if (confirm.equals("yes")) {
                    setRace("Onarii", 0.075, 0, 0.3, 0);
                    break;
                }
                if (confirm.equals("no")) {
                    continue;
                }
            }
            if (race.equals("altherim")) {
                CustomizationOutput.RaceOutput("Altherim");
                System.out.println("\nAre you use you want to be a Altherim? [Yes | No]\n");
                String confirm = PlayerInput();

                if (confirm.equals("yes")) {
                    setRace("Altherim", 0.075, 0, 0.3, 0);
                    break;
                }
                if (confirm.equals("no")) {
                    continue;
                }
            }
            else {
                System.out.println("\nPlease input a valid race\n");
            }
        }

        //  ================================== Class Selection Loop ==================================
        while (true) {
            System.out.println("\nSelect your Class [Rogue | Specialist | Enforcer]\n");
            String playerClass = PlayerInput();

            if (playerClass.equals("rogue")) {
                CustomizationOutput.ClassOutput("Rogue");
                System.out.println("\nAre you use you want to be a Rogue? [Yes | No]\n");
                String confirm = PlayerInput();

                if (confirm.equals("yes")) {
                    setClassRogue(0.125);
                    Game.player.playerClass = "Rogue";
                    break;
                }
                if (confirm.equals("no")) {
                    continue;
                }
            }
            if (playerClass.equals("specialist")) {
                CustomizationOutput.ClassOutput("Specialist");
                System.out.println("\nAre you use you want to be a Specialist? [Yes | No]\n");
                String confirm = PlayerInput();

                if (confirm.equals("yes")) {
                    setClassSpecialist(0.125);
                    Game.player.playerClass = "Specialist";
                    break;
                }
                if (confirm.equals("no")) {
                    continue;
                }
            }
            if (playerClass.equals("enforcer")) {
                CustomizationOutput.ClassOutput("Enforcer");
                System.out.println("\nAre you use you want to be a Enforcer? [Yes | No]\n");
                String confirm = PlayerInput();

                if (confirm.equals("yes")) {
                    setClassEnforcer(0.125);
                    Game.player.playerClass = "Enforcer";
                    break;
                }
                if (confirm.equals("no")) {
                    continue;
                }
            }
            else {
                System.out.println("\nPlease input a valid class\n");
            }
        }

        //  ================================== Name Loop ==================================
        while (true) {
            System.out.println("\nWhat is your name?\n");
            String name = PlayerInput();

            System.out.println("\nYour name is " + name + ". Is that correct? [Yes | No]\n");
            String confirm = PlayerInput();

            if (confirm.equals("yes")) {
                Game.player.name = name;
                break;
            }
            if (confirm.equals("no")) {
                break;
            }
            else {
                System.out.println("\nPlease enter either [Yes | No]\n");
            }
        }

        //  ================================== Summary Loop ==================================
        while (true) {
            CustomizationOutput.SummaryOutput();

            System.out.println("\nIs this correct? [Yes | No]\n");
            String confirm = PlayerInput();

            if (confirm.equals("yes")) {
                break;
            }
            if (confirm.equals("no")) {
                continue;
            }
            else {
                System.out.println("\nPlease enter either [Yes | No]\n");
            }
        }

        Game.saveList.addAll(saveListCC);
        check = 1;
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
