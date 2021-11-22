package view.textview.textcmds;

import view.textview.TextView;

import java.util.Arrays;

public abstract class TextCommand {
    protected TextView textView;

    public TextCommand(TextView textView) {
        this.textView = textView;
    }

    public abstract void execute(String... arguments);

    protected void printUnrecognizedArguments(String[] arguments) {
        System.out.printf("Unrecognized set of arguments: %s\n", Arrays.toString(arguments));
    }

    protected void printFullDescription() {
        System.out.println(getDescription());
        System.out.println(getArgumentSummary());
    }

    protected void printMessage(String message) {
        System.out.println(message);
    }

    protected abstract String getDescription();

    protected abstract String getArgumentSummary();
}
