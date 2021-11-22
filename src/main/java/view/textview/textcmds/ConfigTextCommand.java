package view.textview.textcmds;

import view.textview.TextView;

import java.util.Objects;

public class ConfigTextCommand extends TextCommand{
    public ConfigTextCommand(TextView textView) {
        super(textView);
    }

    @Override
    public void execute(String... arguments) {
        if (arguments.length == 0) {
            printFullDescription();
            return;
        }

        if (Objects.equals(arguments[0], "metrics")) {
            if (arguments.length == 1) {
                printFullDescription();
            }

            if (arguments.length == 2) {
                String metric = arguments[1];
                return;
            }

            if (arguments.length == 3) {
                String metric = arguments[1];
                String value = arguments[2];
                return;
            }

        }

        printUnrecognizedArguments(arguments);
    }

    @Override
    protected String getDescription() {
        return "Configure the program.";
    }

    @Override
    protected String getArgumentSummary() {
        return """
            Arguments:
                metric [name] - View the value of the given metric.
                metric [name] [value] - Set the value of the given metric.""";
    }
}
