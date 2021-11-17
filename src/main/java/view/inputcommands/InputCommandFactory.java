package view.inputcommands;

import view.TextView;

public class InputCommandFactory {
    private final TextView textView;

    public InputCommandFactory(TextView textView) {
        this.textView = textView;
    }

    public InputCommand createCommand(String command, String[] arguments) {
        // TODO Handle arguments
        switch (command) {
            case "exit" :
                return new ExitInputCommand(textView);
            default:
                return new UnrecognizedCommandInputCommand(textView, command);
        }
    }
}
