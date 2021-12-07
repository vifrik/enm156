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

    public void setMetric(String metricName, String value) {
        Metric metric;
        switch (metricName) {
            case CHANGE_TIME -> {
                metric = Metric.ADDITIONAL_CHANGE_TIME;
                int v = Integer.parseInt(value);
                if (v < 5)
                    throw new IllegalArgumentException("Illegal argument: %d".formatted(v));

                value = String.valueOf(v);
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