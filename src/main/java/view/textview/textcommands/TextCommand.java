package view.textview.textcommands;

import view.textview.TextView;

public abstract class TextCommands {
    protected TextView textView;

    public TextCommands(TextView textView) {
        this.textView = textView;
    }

    public abstract void execute();
}
