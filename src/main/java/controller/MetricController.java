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
}