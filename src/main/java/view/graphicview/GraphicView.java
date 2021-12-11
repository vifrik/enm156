package view.graphicview;

import controller.IMetricController;
import controller.ITripController;
import controller.MetricController;
import controller.TripController;
import model.vasttrafik_api.response_classes.name.StopLocationItem;
import model.vasttrafik_api.response_classes.trip.TripResponse;
import view.BaseView;

import javax.swing.*;
import javax.swing.event.*;
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
        sourceSection = new SearchSection(panel, tripController, "Source");
        destinationSection = new SearchSection(panel, tripController, "Destination");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== searchButton){
            var srcList = (JList) sourceSection.scrollPane.getViewport().getView();
            var destList = (JList) destinationSection.scrollPane.getViewport().getView();

            Object rawSrc = srcList.getSelectedValue();
            if (rawSrc == null) return;
            StopLocationItem src = (StopLocationItem) rawSrc;

            Object rawDest = destList.getSelectedValue();
            if (rawDest == null) return;
            StopLocationItem dest = (StopLocationItem) rawDest;

            TripResponse trip = tripController.findTrip(src.getId(), dest.getId());
            new TripWindow(trip, src, dest, tripController);
        }

        if(e.getSource()==menuItem) {
            frame.setVisible(false);
            new MenuWindow(this);
        }
    }
}


record SearchBoxDocumentListener(ITripController tripController, JScrollPane jScrollPane,
                                 JTextField jTextField) implements DocumentListener {

    @Override
    public void insertUpdate(DocumentEvent e) {
        updateScrollPane();
    }

    private void updateScrollPane() {
        var text = jTextField.getText();


        var nameResponse = tripController.findNames(text);

        var jList = new JList<>(nameResponse.getLocationList().getStopLocation().toArray());

        jScrollPane.setViewportView(jList);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {

    }

    @Override
    public void changedUpdate(DocumentEvent e) {
    }
}

