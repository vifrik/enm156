package view.textview.textcmds;

import view.textview.TextView;

import java.util.HashMap;

public class HelpTextCommand extends TextCommand {
    private final HashMap<String, TextCommand> commandMap;

    public HelpTextCommand(TextView textView, HashMap<String, TextCommand> commandMap) {
        super(textView);
        this.commandMap = commandMap;
    }

    @Override
    public void execute(String... arguments) {
        if (arguments.length > 0) {
            printUnrecognizedArguments(arguments);
            return;
        }

        for (String name:commandMap.keySet()) {
            String description = commandMap.get(name).getDescription();
            printMessage("%s: %s".formatted(name, description));
        }
    }

    @Override
    protected String getDescription() {
        return "Prints out a list of all possible commands";
    }

    @Override
    protected String getArgumentSummary() {
        // TODO Calling help on a function displays name and argument list
        return null;
    }
}
