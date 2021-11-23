package view.textview.textcmds;

import view.textview.TextView;

import java.util.Arrays;
import java.util.HashMap;

public class TextCommandManager {
    private final HashMap<String, TextCommand> commandMap;

    public TextCommandManager(TextView textView) {
        commandMap = new HashMap<>();
        commandMap.put("help", new HelpTextCommand(textView, commandMap));
        commandMap.put("exit", new ExitTextCommand(textView));
        commandMap.put("config", new ConfigTextCommand(textView, new MockMetricManager()));
    }

    public void executeCommand(String[] words) {
        String command = words.length == 0 ? null : words[0];
        String[] arguments = words.length < 2 ? new String[0] : Arrays.copyOfRange(words, 1, words.length);
        executeCommand(command, arguments);
    }

    public void executeCommand(String name, String... arguments) {
        TextCommand cmd = commandMap.get(name);

        if (cmd == null) {
            System.out.printf("Unknown command '%s'.\n", name);
            return;
        }

        cmd.execute(arguments);
    }
}
