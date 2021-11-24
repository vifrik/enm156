package controller;

public interface IMetricController {
    public String getMetric(String name);
    void setValue(String name, String value);
}
