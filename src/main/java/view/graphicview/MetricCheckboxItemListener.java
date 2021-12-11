package view.graphicview;

import controller.IMetricController;
import controller.Metric;
import controller.MetricController;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MetricCheckboxItemListener implements ItemListener {
    IMetricController metricController;
    JCheckBox checkBox;
    Metric metric;

    public MetricCheckboxItemListener(IMetricController metricController, JCheckBox checkBox, Metric metric) {
        this.metricController = metricController;
        this.checkBox = checkBox;
        this.metric = metric;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            metricController.setMetric(metric, "1");
        } else {
            metricController.setMetric(metric, "0");
        }
    }
}
