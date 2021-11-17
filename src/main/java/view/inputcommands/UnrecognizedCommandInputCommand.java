package view.inputcommands;

import view.TextView;

public class UnrecognizedCommandInputCommand extends InputCommand{
    private final String command;

    UnrecognizedCommandInputCommand(TextView textView, String command) {
        super(textView);
        this.command = command;
    }

    @Override
    public void execute() {
        System.out.printf("Unrecognized command: %s%n", command);
    }
}
