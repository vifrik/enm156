package view.inputcommands;

import view.TextView;

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
