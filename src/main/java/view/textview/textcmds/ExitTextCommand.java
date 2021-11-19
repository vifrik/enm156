package view.textview.textcmds;

import view.textview.TextView;

public class ExitTextCommand extends TextCommand {
    ExitTextCommand(TextView textView) {
        super(textView);
    }

    @Override
    public void execute(String... arguments) {
        if (arguments.length > 0)
            handleUnrecognizedArguments(arguments);

        System.out.println("Exiting program.");
        textView.stopRunning();
    }

    @Override
    protected String getDescription() {
        return "Exits the program";
    }
}
