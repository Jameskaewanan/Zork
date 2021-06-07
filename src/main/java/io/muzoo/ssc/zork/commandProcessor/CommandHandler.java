package io.muzoo.ssc.zork.commands;

import java.util.Arrays;
import java.util.List;

public class CommandHandler {

    public List<String> parse(String stringInput) {
        String[] strings = stringInput.trim().split(" ");
        return Arrays.asList(strings);
    }



}
