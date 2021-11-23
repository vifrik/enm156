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
        parseArguments(arguments);
    }

    private void parseArguments(String[] arguments) {
        switch (arguments.length) {
            case 0 -> displayCommandList();
            case 1 -> {
                String commandName = arguments[0];
                displayFullDescription(commandName);
            }
            default -> printUnrecognizedArguments(arguments);
        }

    }

    private void displayFullDescription(String commandName) {
        TextCommand command = commandMap.get(commandName);
        command.printFullDescription();
    }

    private void displayCommandList() {
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
        return """
            Arguments:
                help [command] - Shows full description of command.""";
    }
}
