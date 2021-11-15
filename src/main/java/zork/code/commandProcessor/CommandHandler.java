package zork.code.commandProcessor;

public class CommandHandler { // Parsing player input

    public String[] parse(String stringInput) {
        String[] strings = stringInput.trim().split(" ");
        return strings;
    }

}
