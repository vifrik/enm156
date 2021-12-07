package controller;

public interface IMetricController {
    public String getMetric(Metric name);
    public String getMetric(String metricName);

    void setMetric(Metric name, String value);
    void setMetric(String metricName, String value);
}
