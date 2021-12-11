package controller;

import java.util.HashMap;
import java.util.Map;

public class MetricController implements IMetricController {
    public final static String CHANGE_TIME = "change-time";
    public final static String ADDITIONAL_CHANGE_TIME = "additional-change-time";
    Map<Metric, String> metrics = new HashMap<>();

    @Override
    public String getMetric(Metric metric) {
        return metrics.getOrDefault(metric, null);
    }

    @Override
    public void setMetric(Metric metric, String value) {
        metrics.put(metric, value);
    }

    @Override
    public String getMetric(String metricName) {

        switch (metricName) {
            case CHANGE_TIME -> {
                String additionalChangeTime = getMetric(Metric.ADDITIONAL_CHANGE_TIME);
                int act = Integer.parseInt(additionalChangeTime);
                return String.valueOf(act + 5);
            }
            case ADDITIONAL_CHANGE_TIME -> {
                return getMetric(Metric.ADDITIONAL_CHANGE_TIME);
            }
            default -> throw new IllegalArgumentException();
        }
    }

    @Override
    public void setMetric(String metricName, String value) throws IllegalArgumentException {
        Metric metric;
        switch (metricName) {
            case CHANGE_TIME -> {
                metric = Metric.ADDITIONAL_CHANGE_TIME;
                int v = Integer.parseInt(value);
                if (v < 5)
                    throw new IllegalArgumentException("Illegal argument: %d".formatted(v));

                value = String.valueOf(v - 5);
            }
            case ADDITIONAL_CHANGE_TIME -> {
                metric = Metric.ADDITIONAL_CHANGE_TIME;
                int v = Integer.parseInt(value);
                if (v < 0)
                    throw new IllegalArgumentException("Illegal argument: %d".formatted(v));
            }
            default -> throw new IllegalArgumentException("Illegal argument: %s".formatted(metricName));
        }

        metrics.put(metric, value);
    }

    private record MetricValuePair(Metric metric, String value) {
    }
}