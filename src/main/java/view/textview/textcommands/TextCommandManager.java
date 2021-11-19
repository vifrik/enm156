package view.textview.textcommands;

import org.jgrapht.alg.util.Pair;
import view.textview.TextView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Supplier;

public class TextCommandFactory {
    private final HashMap<String, Supplier<TextCommand>> dispatchMap;

    public TextCommandFactory(TextView textView) {
        dispatchMap = new HashMap<>();
        dispatchMap.put("help", () -> new HelpTextCommand(textView));
        dispatchMap.put("exit", () -> new ExitTextCommand(textView));
    }

    public TextCommand getCommand(String name, String... arguments) {
        TextCommand cmd = createCommand(name);
        if (cmd.argumentsValid(arguments)) {
            cmd.execute(arguments);
        }
    }

    public TextCommand getCommand(String... words) {
        Pair<String, String[]> nameArgs = splitCommandAndArguments(words);
        return getCommand(nameArgs.getFirst(), nameArgs.getSecond());
    }

    private TextCommand createCommand(String name) {
        Supplier<TextCommand> commandConstructor = dispatchMap.get(name);
        return commandConstructor.get();
    }


    private Pair<String, String[]> splitCommandAndArguments(String[] words) {
        String command;
        String[] arguments;

        command = words.length == 0 ? null : words[0];
        arguments = words.length < 2 ? new String[0] : Arrays.copyOfRange(words, 1, words.length);

        return new Pair<>(command, arguments);
    }
}
