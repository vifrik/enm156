package view.graphicview;

import controller.*;
import model.vasttrafik_api.response_classes.name.StopLocationItem;
import view.BaseView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicView extends BaseView implements ActionListener  {
    JFrame frame;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;

    IMetricController metricController;
    ITripController tripController;

    private SearchSection sourceSection;
    private SearchSection destinationSection;
    private JButton searchButton;
    private JPanel panel;

    public GraphicView() {
        super();
        metricController = new MetricController();
        tripController = new TripController(metricController);

        tripController.setWeight(Weights.AVOID_CENTRAL, 5);
        tripController.setWeight(Weights.AVOID_CHANGES, 5);
    }

    public static void main(String[] args) {
        BaseView userInterface = new GraphicView();
        userInterface.start();
    }

    @Override
    protected void setup() {
        createFrame();
        configureFrameExit();
        setupFrameComponents();
        sizeFrame();
        showFrame();
    }

    @Override
    protected void run() {

    }

    @Override
    protected void cleanup() {

    }

    private void createFrame() {
        frame = new JFrame();
        frame.setTitle("Västtrafik");
        frame.setResizable(true);

        ImageIcon image = new ImageIcon("buss.png");
        frame.setIconImage(image.getImage());
    }

    private void configureFrameExit() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void setupFrameComponents() {
        createPanel();
        createMenu();
        createSections();
        createSliders(panel);
        createCheckBoxes(panel);
        createFooter();
    }



    private void sizeFrame() {
        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    private void showFrame() {
        frame.setVisible(true);
    }

    private void createPanel() {
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.decode("#B4B8AB"));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        frame.add(panel);
    }

    private void createMenu() {
        menuBar = new JMenuBar();
        menu = new JMenu("Meny");
        menuItem = new JMenuItem("Filter");
        menuItem.addActionListener(this);
        menu.add(menuItem);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);
    }

    private void createFooter() {
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(Color.decode("#284B63"));

        //button
        searchButton = new JButton("Sök");
        searchButton.addActionListener(this);
        footerPanel.add(searchButton);

        frame.add(footerPanel, BorderLayout.AFTER_LAST_LINE);
    }

    private void createSections() {
        sourceSection = new SearchSection(panel, tripController, "Källa");
        destinationSection = new SearchSection(panel, tripController, "Destination");
    }

    private void createSlider(JPanel panel, String name, Metric metric, int min, int max, int defaultValue, int offset, int scale) {
        JLabel label = new JLabel();
        label.setText(name);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setForeground(Color.decode("#284B63"));
        label.setFont(new Font("Sans-Serif", Font.PLAIN, 18));

        JSlider slider = new JSlider(JSlider.HORIZONTAL,min,max,defaultValue);
        slider.addChangeListener(new MetricSliderChangeListener(metricController, slider, metric, offset));
        slider.setMinorTickSpacing(1);
        slider.setMajorTickSpacing(scale);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        panel.add(label);
        panel.add(slider);
    }

    private void createSliders(JPanel panel) {
        createSlider(panel, "Bytestid", Metric.ADDITIONAL_CHANGE_TIME, 5, 60, 5, 5, 5);
        createSlider(panel, "Maximalt gångavstånd", Metric.ADDITIONAL_CHANGE_TIME, 0, 10000, 2000, 0, 1000);
    }

    private void createCheckBox (JPanel panel, String title, Metric metric) {
        JCheckBox jCheckBox = new JCheckBox();
        jCheckBox.setText(title);
        jCheckBox.addItemListener(new MetricCheckboxItemListener(metricController, jCheckBox, metric));

        panel.add(jCheckBox);
    }

    private void createCheckBoxes(JPanel panel) {
        JPanel subPanel = new JPanel(new GridLayout(0, 3));

        createCheckBox(subPanel, "Rullstolsplatts", Metric.WHEEL_CHAIR_SPACE);
        createCheckBox(subPanel, "Barnvagnsplatts", Metric.STROLLER_SPACE);
        createCheckBox(subPanel, "Lågt golv", Metric.LOW_FLOOR);
        createCheckBox(subPanel, "Ramp eller hiss", Metric.RAMP_OR_LIFT);

        panel.add(subPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== searchButton){
            findTrip();
        }

        if(e.getSource()==menuItem) {
            frame.setVisible(false);
            new MenuWindow(this);
        }
    }

    @SuppressWarnings("unchecked cast")
    private void findTrip() {
        var srcList = (JList<StopLocationItem>) sourceSection.scrollPane.getViewport().getView();
        var destList = (JList<StopLocationItem>) destinationSection.scrollPane.getViewport().getView();

        var srcItem = srcList.getSelectedValue();
        var destItem = destList.getSelectedValue();
        if (srcItem == null || destItem == null) return;
        if(srcItem.toString().equals(destItem.toString())) return;

        var trip = tripController.findTrip(srcItem.getId(), destItem.getId());
        new TripWindow(trip, srcItem, destItem, "nu", tripController);
    }
}


