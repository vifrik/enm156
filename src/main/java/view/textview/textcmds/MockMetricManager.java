package view.textview.textcmds;

import controller.IMetricController;
import controller.Metric;

public class MockMetricManager implements IMetricController {
    @Override
    public String getMetric(Metric name) {
        System.out.println("Value not defined!");
        return null;
    }

    @Override
    public void setMetric(Metric name, String value) {
        System.out.println("Set value to value");
    }
}
