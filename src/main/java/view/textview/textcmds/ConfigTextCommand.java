package view.textview.textcmds;

import view.textview.TextView;

import java.util.Objects;

public class ConfigTextCommand extends TextCommand{
    public ConfigTextCommand(TextView textView) {
        super(textView);
    }

    @Override
    public void execute(String... arguments) {
        if (arguments.length == 0)
            System.out.println(getDescription());
        else if (Objects.equals(arguments[0], "metrics"))
            System.out.println("config metrics are not implemented yet.");
        else
            handleUnrecognizedArguments(arguments);
    }

    @Override
    protected String getDescription() {
        return null;
    }
}
