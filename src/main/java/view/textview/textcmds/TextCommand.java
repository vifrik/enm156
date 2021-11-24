package view.textview.textcmds;

import view.textview.TextView;

import java.util.Arrays;
import java.util.List;

public abstract class TextCommand {
    protected TextView textView;

    public TextCommand(TextView textView) {
        this.textView = textView;
    }

    public abstract void execute(String... arguments);

    protected void printFullDescription() {
        printDescription();
        printArgumentSummary();
    }

    protected void printUnrecognizedArguments(String... arguments) {
        printMessage("Unrecognized set of arguments: %s".formatted(Arrays.toString(arguments)));
    }

    protected void printDescription() {
        String description = getDescription();
        if (description != null)
            printMessage(description);
    }

    protected void printArgumentSummary() {
        String argumentSummary = getArgumentSummary();
        if (argumentSummary != null)
            printMessage(argumentSummary);
    }

    protected void printMessage(String message) {
        System.out.println(message);
    }

    protected abstract String getDescription();

    protected String getArgumentSummary() {
        List<String> arguments = getArgumentList();
        if (arguments == null || arguments.isEmpty())
            return null;

        StringBuilder sb = new StringBuilder();
        sb.append("Arguments:");
        for(String arg : arguments)
            sb.append("\n\t").append(arg);
        sb.append('\n');
        return sb.toString();
    }

    protected abstract List<String> getArgumentList();
}
