package controller;

import java.util.HashMap;
import java.util.Map;

public class MetricController implements IMetricController {
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
        Metric metric = parseMetric(metricName);
    }

    private Metric parseMetric(String metricName) {
        return switch (metricName) {
            case "change" -> Metric.ADDITIONAL_CHANGE_TIME;
        }
    }
}