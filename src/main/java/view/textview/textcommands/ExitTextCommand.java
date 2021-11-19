package view.textview.textcommands;

import view.textview.TextView;

public class ExitInputCommand extends InputCommand {
    ExitInputCommand(TextView textView) {
        super(textView);
    }

    @Override
    public void execute() {
        System.out.println("Exiting program.");
        textView.stopRunning();
    }
}
