package view.textview.textcmds;

import controller.IMetricController;
import controller.Metric;
import controller.MetricController;
import view.textview.TextView;

import java.util.Arrays;
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
                try {
                    String value = metricManager.getMetric(metricName);
                }
                catch (IllegalArgumentException e) {
                    System.out.printf("Illegal arguments set: %s%n", String.join(",", arguments));
                }
            }
            case 3 -> {
                String metricName = arguments[1];
                String metricValue = arguments[2];
                try {
                    metricManager.setMetric(metricName, metricValue);
                }
                catch (IllegalArgumentException e) {
                    System.out.printf("Illegal arguments set: %s%n", String.join(",", arguments));
                }
            }
        }
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
