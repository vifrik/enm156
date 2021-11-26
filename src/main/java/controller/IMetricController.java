package controller;

public interface IMetricController {
    public String getMetric(Metric name);

    void setMetric(Metric name, String value);
}
