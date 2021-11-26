package view.textview.textcmds;

import controller.IMetricController;

public class MockMetricManager implements IMetricController {
    @Override
    public String getMetric(String name) {
        return "Value of %s is not defined!".formatted(name);
    }

    @Override
    public void setMetric(String name, String value) {
        System.out.printf("Set value of %s to %s\n", name, value);
    }
}
