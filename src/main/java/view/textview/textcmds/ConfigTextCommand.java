package view.textview.textcmds;

import controller.IMetricManager;
import view.textview.TextView;

import java.util.Objects;

public class ConfigTextCommand extends TextCommand{
    private IMetricManager metricManager;

    public ConfigTextCommand(TextView textView, IMetricManager metricManager) {
        super(textView);
        this.metricManager = metricManager;
    }

    @Override
    public void execute(String... arguments) {
        parseArguments(arguments);
    }

    private void parseArguments(String[] arguments) {
        if (arguments.length == 0)
            printFullDescription();

        else if (Objects.equals(arguments[0], "metric")) {
            parseMetricsArguments(arguments);
        }

        else printUnrecognizedArguments(arguments);
    }

    private void parseMetricsArguments(String[] arguments) {
        switch (arguments.length) {
            case 1 -> printFullDescription();
            case 2 -> {
                String metricName = arguments[1];
                displayMetricWithName(metricName);
            }
            case 3 -> {
                String metricName = arguments[1];
                String metricValue = arguments[2];
                setValueOfMetricWithName(metricName, metricValue);
            }
        }
    }

    private void setValueOfMetricWithName(String name, String value) {
        metricManager.setValue(name, value);
    }

    private void displayMetricWithName(String name) {
        printMessage(metricManager.getMetric(name));
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