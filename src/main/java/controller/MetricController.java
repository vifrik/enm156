package controller;

import java.util.Map;

public class MetricController implements IMetricController {
    Map<Metric, String> metrics;

    @Override

    public String getMetric(Metric name) {
        return metrics.getOrDefault(name, null);
    }

    @Override
    public void setMetric(Metric name, String value) {
        metrics.put(name, value);
    }
}