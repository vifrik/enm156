package view.textview.textcmds;

import controller.IMetricManager;

public class MockMetricManager implements IMetricManager {
    @Override
    public String getMetric(String name) {
        return "Value of %s is not defined!".formatted(name);
    }

    @Override
    public void setValue(String name, String value) {
        System.out.printf("Set value of %s to %s\n", name, value);
    }
}
