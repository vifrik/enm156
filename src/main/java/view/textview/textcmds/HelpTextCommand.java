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
        if (arguments.length > 0)
            handleUnrecognizedArguments(arguments);

        for (String name:commandMap.keySet()) {
            System.out.printf("%s: %s\n", name, commandMap.get(name).getDescription());
        }
    }

    @Override
    protected String getDescription() {
        return "Prints out a list of all possible commands";
    }
}
