package view.textview.textcmds;

import controller.IMetricController;
import controller.Metric;
import view.textview.TextView;

import java.util.List;
import java.util.Objects;

public class ConfigTextCommand extends TextCommand {
    private final IMetricController metricManager;

    public ConfigTextCommand(TextView textView, IMetricController metricManager) {
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

        else if (Objects.equals(arguments[0], "metric"))
            parseMetricsArguments(arguments);

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

    private void setValueOfMetricWithName(String name, String value) throws IllegalArgumentException {
        Metric metric;

        switch (name) {
            case "change-time" -> {
                metric = Metric.ADDITIONAL_CHANGE_TIME;
                int v = Integer.parseInt(value);
                if (v < 5)
                    throw new IllegalArgumentException("Illegal argument: %d".formatted(v));

                int additionalChangeTime = v - 5;
                value = String.valueOf(additionalChangeTime);
            }
            default -> throw new IllegalArgumentException("Illegal argument: %s".formatted(name));
        }


        metricManager.setMetric(metric, value);
    }

    private void displayMetricWithName(String name) {
        switch ()
        printMessage(metricManager.getMetric(metric));
    }


    @Override
    protected String getDescription() {
        return "Configure the program.";
    }

    @Override
    protected List<String> getArgumentList() {
        return List.of(
                "metric [name] - View the value of the given metric.",
                "metric [name] [value] - Set the value of the given metric."
        );
    }

}
