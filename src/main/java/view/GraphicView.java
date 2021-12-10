package view;

import controller.IMetricController;
import controller.ITripController;
import controller.MetricController;
import controller.TripController;
import model.vasttrafik_api.response_classes.name.NameResponse;
import model.vasttrafik_api.response_classes.name.StopLocationItem;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicView extends BaseView implements ChangeListener, ActionListener, ListSelectionListener, DocumentListener {
    JTextField textField;
    JFrame frame;
    private JButton searchButton, sourceSelect, destSelect;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;
    JScrollPane srcScrollPane;

    IMetricController metricController;
    ITripController tripController;
    private JList destList;
    private JList sourceList;
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
        JPanel panel1 = new JPanel(new BorderLayout());
        panel1.setPreferredSize(new Dimension(420, 500));
        panel1.setBackground(Color.green);
        panel1.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel1.setLayout(new GridLayout(0, 1));
        frame.add(panel1, BorderLayout.CENTER);

        //Start
        sourceList = new JList<>();
        sourceList.setVisibleRowCount(5);

        //Destination
        destList = new JList<>();
        destList.setVisibleRowCount(5);

        JLabel start = new JLabel("Start");
        start.setHorizontalAlignment(JLabel.CENTER);
        panel1.add(start);

        //Textfield 1
        srcScrollPane = new JScrollPane(sourceList);
        textField =  new JTextField();
        textField.getDocument().addDocumentListener(new SearchBoxDocumentListener(srcScrollPane, textField));
        panel1.add(textField);

        //Scroll
        srcScrollPane.setViewportView(sourceList);
        sourceList.setLayoutOrientation(JList.VERTICAL);
        panel1.add(srcScrollPane);


        //Menu
        menuBar = new JMenuBar();

        menu = new JMenu("Meny");

        menuItem = new JMenuItem("Filter");
        menuItem.addActionListener(this);
        menu.add(menuItem);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        sourceSelect = new JButton("Välj");
        sourceSelect.addActionListener(this);
        panel1.add(sourceSelect);

        //Label
        JLabel destination = new JLabel("Destination");
        destination.setHorizontalTextPosition(JLabel.CENTER);
        destination.setHorizontalAlignment(JLabel.CENTER);
        panel1.add(destination);

        //Scroll 2
        destScrollPane = new JScrollPane(destList);
        destScrollPane.setViewportView(destList);
        destList.setLayoutOrientation(JList.VERTICAL);

        //Textfield 2
        JTextField textField2 = new JTextField();
        textField2.getDocument().addDocumentListener(new SearchBoxDocumentListener(destScrollPane, textField2));
        panel1.add(textField2);
        panel1.add(destScrollPane);

        destList.addListSelectionListener(this);
        destSelect = new JButton("Välj");
        destSelect.addActionListener(this);
        panel1.add(destSelect);

        //Panel 2
        JPanel panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(0, 50));
        panel2.setBackground(Color.BLUE);
        frame.add(panel2, BorderLayout.AFTER_LAST_LINE);

        //Label
        JLabel label = new JLabel("Välj din säkerhets faktor");
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        panel1.add(label);


        //button
        searchButton = new JButton("Sök");
        searchButton.addActionListener(this);
        panel2.add(searchButton);

    }

    private void sizeFrame() {
        frame.setSize(400, 400);
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
            var srcList = (JList) srcScrollPane.getViewport().getView();
            var destList = (JList) destScrollPane.getViewport().getView();

            var rawSrc = srcList.getSelectedValue();
            if (rawSrc == null) return;
            var src = (StopLocationItem) rawSrc;

            var rawDest = destList.getSelectedValue();
            if (rawDest == null) return;
            var dest = (StopLocationItem) rawDest;

            var trip = tripController.findTrip(src.getId(), dest.getId());
            JOptionPane.showMessageDialog(frame, trip);
        }
        if(e.getSource()==menuItem) {
            frame.setVisible(false);
            NewWindow myWindow = new NewWindow(this);
        }
        if (e.getSource() == sourceSelect) {
            String text = textField.getText();
            System.out.println(text);

        }
        if (e.getSource() == destSelect) {
            String text = textField.getText();
            System.out.println(text);
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

            sourceList.removeAll();

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
