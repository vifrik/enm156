package view.textview.textcmds;

import view.textview.TextView;

import java.util.Arrays;

public abstract class TextCommand {
    protected TextView textView;

    public TextCommand(TextView textView) {
        this.textView = textView;
    }

    public abstract void execute(String... arguments);

    protected void handleUnrecognizedArguments(String[] arguments) {
        System.out.printf("Unrecognized set of arguments: %s\n", Arrays.toString(arguments));
    }

    protected abstract String getDescription();
}
