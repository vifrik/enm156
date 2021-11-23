package controller;

public interface IMetricManager {
    public String getMetric(String name);
    void setValue(String name, String value);
}
