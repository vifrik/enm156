package view.inputcommands;

import view.TextView;

public abstract class InputCommand {
    protected TextView textView;

    public InputCommand(TextView textView) {
        this.textView = textView;
    }

    public abstract void execute();
}
