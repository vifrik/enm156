package view.graphicview;

import controller.Metric;
import controller.Weights;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuWindow implements  ActionListener {
    JFrame frame;
    JButton helpButton, backButton;
    private final GraphicView graphicView;
    private JPanel panel;

    MenuWindow(GraphicView graphicView){
        this.graphicView = graphicView;

        createFrame();
        createPanel();

        createSliders();
        createCheckBoxes();
        createControlButtons();

        configFrame();
    }

    private void createFrame() {
        frame = new JFrame("Västtrafik");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon image = new ImageIcon("buss.png");
        frame.setIconImage(image.getImage());
        frame.setSize(500,500);
        //frame.setLayout();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void createPanel() {
        panel = new JPanel(new GridLayout(0,1));
        panel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
    }

    private void createSliders() {
        createSlider(panel, "Bytestid", Metric.ADDITIONAL_CHANGE_TIME, 5, 60, 5, 5, 5, 1);
        createSlider(panel, "Maximalt gångavstånd", Metric.MAX_WALK_DISTANCE, 0, 10000, 2000, 0, 1000, 100);
    }

    private void createCheckBoxes() {
        JPanel subPanel = new JPanel(new GridLayout(0, 3));

        createCheckBox(subPanel, "Rullstolsplatts", Metric.WHEEL_CHAIR_SPACE);
        createCheckBox(subPanel, "Barnvagnsplatts", Metric.STROLLER_SPACE);
        createCheckBox(subPanel, "Lågt golv", Metric.LOW_FLOOR);
        createCheckBox(subPanel, "Ramp eller hiss", Metric.RAMP_OR_LIFT);

        panel.add(subPanel);
    }

    private void createControlButtons() {
        helpButton = createButton(panel, "Hjälp", new Rectangle(200, 250, 100, 40));
        backButton = createButton(panel, "Tillbaka", new Rectangle(200, 300, 100, 40));
    }

    private void configFrame() {
        frame.add(panel, BorderLayout.AFTER_LAST_LINE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void createCheckBox (JPanel panel, String title, Metric metric) {
        JCheckBox jCheckBox = new JCheckBox();
        jCheckBox.setText(title);
        jCheckBox.addItemListener(new MetricCheckboxItemListener(graphicView.metricController, jCheckBox, metric));

        panel.add(jCheckBox);
    }

    private JButton createButton(JPanel panel, String title, Rectangle bounds) {
        var button = new JButton(title);
        button.setBounds(bounds);
        button.addActionListener(this);
        panel.add(button);
        return button;
    }
    private void createSlider(JPanel panel, String name, Metric metric, int min, int max, int defaultValue, int offset, int scale, int minorTickSpacing) {
        System.out.println(panel);
        JLabel label = new JLabel();
        label.setText(name);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setForeground(Color.decode("#284B63"));
        label.setFont(new Font("Sans-Serif", Font.PLAIN, 18));

        JSlider slider = new JSlider(JSlider.HORIZONTAL,min,max,defaultValue);
        slider.addChangeListener(new MetricSliderChangeListener(graphicView.metricController, slider, metric, offset));
        slider.setMinorTickSpacing(1);
        slider.setMajorTickSpacing(scale);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        panel.add(label);
        panel.add(slider);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== helpButton){
            JOptionPane.showMessageDialog(frame,"Bytestid: Minsta antalet minuter ett byte ska räknas ta");
        }
        if (e.getSource() == backButton) {
            graphicView.frame.setVisible(true);
            frame.dispose();
        }
    }
}
