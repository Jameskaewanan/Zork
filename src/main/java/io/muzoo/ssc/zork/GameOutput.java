package io.muzoo.ssc.zork;

public class GameOutput {

    public void println(String msg) {
        System.out.println(msg);
    }

    public void print(String msg) {
        System.out.print(msg);
    }

    public void welcomeScreen() {

        System.out.println();
        System.out.println("############################");
        System.out.println("#                          #");
        System.out.println("#        Weclome To        #");
        System.out.println("#           ZORK           #");
        System.out.println("#                          #");
        System.out.println("############################");

        System.out.println();
        System.out.println("Welcome to a bare bones version of Zork!");
        System.out.println("You will traverse dungeons and stuff");
        System.out.println("You will kill things");
        System.out.println();
        System.out.println("Select from the following options");
        System.out.println("play <map> - choose a map and play");
        System.out.println("load <save name> - load a previous save");
        System.out.println();

    }

}
