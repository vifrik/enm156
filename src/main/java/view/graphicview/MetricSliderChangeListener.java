package view.graphicview;

import controller.IMetricController;
import controller.Metric;
import controller.MetricController;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MetricSliderChangeListener implements ChangeListener {
    IMetricController metricController;
    JSlider jSlider;
    Metric metric;
    int offset;

    public MetricSliderChangeListener(IMetricController metricController, JSlider jSlider, Metric metric, int offset) {
        this.metricController = metricController;
        this.jSlider = jSlider;
        this.metric = metric;
        this.offset = offset;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        metricController.setMetric(metric, Integer.toString(jSlider.getValue()-offset));
    }
}
