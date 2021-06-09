package io.muzoo.ssc.zork.commandProcessor;

import java.util.Arrays;
import java.util.List;

public class CommandHandler {

    public String[] parse(String stringInput) {
        String[] strings = stringInput.trim().split(" ");
        return strings;
    }

}
