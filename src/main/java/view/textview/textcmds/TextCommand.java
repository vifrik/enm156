package view.textview.textcmds;

import view.textview.TextView;

import java.util.Arrays;

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

    protected abstract String getArgumentSummary();
}
