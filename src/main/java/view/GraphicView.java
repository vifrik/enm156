package view;

import controller.IMetricController;
import controller.ITripController;
import controller.MetricController;
import controller.TripController;
import model.vasttrafik_api.response_classes.name.NameResponse;
import model.vasttrafik_api.response_classes.name.StopLocationItem;
import model.vasttrafik_api.response_classes.trip.TripResponse;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicView extends BaseView implements ChangeListener, ActionListener, ListSelectionListener, DocumentListener {
    private static final int STD_HEIGHT = 50;
    private static final int STD_WIDTH = 50;

    JTextField sourceInput;
    JFrame frame;
    private JButton searchButton;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;
    JScrollPane srcScrollPane;

    IMetricController metricController;
    ITripController tripController;
    private JScrollPane destScrollPane;

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

    private void createFrame() {
        frame = new JFrame();
    }

    private void configureFrameExit() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void setupFrameComponents() {
        //frame
        frame.setTitle("Västtrafik");
        frame.setResizable(true);

        ImageIcon image = new ImageIcon("buss.png");
        frame.setIconImage(image.getImage());

        //Panel
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel1.setBackground(Color.decode("#B4B8AB"));
        panel1.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        frame.add(panel1);

        JLabel start = new JLabel("Start");
        start.setAlignmentX(Component.CENTER_ALIGNMENT);
        start.setForeground(Color.decode("#284B63"));
        start.setFont(new Font("Sans-Serif", Font.PLAIN, 18));
        panel1.add(start);

        //Textfield 1
        sourceInput =  new JTextField();
        srcScrollPane = new JScrollPane();
        sourceInput.getDocument().addDocumentListener(new SearchBoxDocumentListener(srcScrollPane, sourceInput));
        sourceInput.setPreferredSize(new Dimension(400, STD_HEIGHT/2));
        srcScrollPane.setPreferredSize(new Dimension(400, STD_HEIGHT*2));

        panel1.add(sourceInput);
        panel1.add(srcScrollPane);

        //Menu
        menuBar = new JMenuBar();
        menu = new JMenu("Meny");
        menuItem = new JMenuItem("Filter");
        menuItem.addActionListener(this);
        menu.add(menuItem);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        //Label
        JLabel destination = new JLabel("Destination");
        destination.setAlignmentX(Component.CENTER_ALIGNMENT);
        destination.setForeground(Color.decode("#284B63"));
        destination.setFont(new Font("Sans-Serif", Font.PLAIN, 18));
        panel1.add(destination);


        JTextField destInput = new JTextField();
        destScrollPane = new JScrollPane();
        destInput.getDocument().addDocumentListener(new SearchBoxDocumentListener(destScrollPane, destInput));
        destInput.setPreferredSize(new Dimension(400, STD_HEIGHT/2));
        destScrollPane.setPreferredSize(new Dimension(400, STD_HEIGHT*2));

        panel1.add(destInput);
        panel1.add(destScrollPane);

        //Panel 2
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(Color.decode("#284B63"));

        //button
        searchButton = new JButton("Sök");
        searchButton.addActionListener(this);
        footerPanel.add(searchButton);

        frame.add(footerPanel, BorderLayout.AFTER_LAST_LINE);
    }

    private void sizeFrame() {
        //frame.setSize(400, 400);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    private void showFrame() {
        frame.setVisible(true);
    }

    @Override
    protected void run() {

    }

    @Override
    protected void cleanup() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== searchButton){
            JList srcList = (JList) srcScrollPane.getViewport().getView();
            JList destList = (JList) destScrollPane.getViewport().getView();

            Object rawSrc = srcList.getSelectedValue();
            if (rawSrc == null) return;
            StopLocationItem src = (StopLocationItem) rawSrc;

            Object rawDest = destList.getSelectedValue();
            if (rawDest == null) return;
            StopLocationItem dest = (StopLocationItem) rawDest;

            TripResponse trip = tripController.findTrip(src.getId(), dest.getId());
            //TripResponse trip = tripController.findTrip("9022014001960001", "9021014004945000");
            TripWindow tripWindow = new TripWindow(trip, src, dest, tripController);
            //JOptionPane.showMessageDialog(frame, trip);
        }
        if(e.getSource()==menuItem) {
            frame.setVisible(false);
            NewWindow myWindow = new NewWindow(this);
        }

    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }

    @Override
    public void insertUpdate(DocumentEvent e) {

    }

    @Override
    public void removeUpdate(DocumentEvent e) {

    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

    }

    class SearchBoxDocumentListener implements DocumentListener {
        private JScrollPane jScrollPane;
        private JTextField jTextField;

        public SearchBoxDocumentListener(JScrollPane jScrollPane, JTextField jTextField) {
            this.jScrollPane = jScrollPane;
            this.jTextField = jTextField;
        }

        private void updateSourceList() {
            NameResponse nameResponse = tripController.findNames(jTextField.getText());

            var jList = new JList<>(nameResponse.getLocationList().getStopLocation().toArray());

            jScrollPane.setViewportView(jList);
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            updateSourceList();

        }

        @Override
        public void removeUpdate(DocumentEvent e) {

        }

        @Override
        public void changedUpdate(DocumentEvent e) {
        }
    }
}
