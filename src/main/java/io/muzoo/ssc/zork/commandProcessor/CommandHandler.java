package io.muzoo.ssc.zork.commandProcessor;

import java.util.Arrays;
import java.util.List;

public class CommandHandler { // Parsing player input

    public String[] parse(String stringInput) {
        String[] strings = stringInput.trim().split(" ");
        return strings;
    }

}
