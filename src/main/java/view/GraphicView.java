package view;

import controller.IMetricController;
import controller.ITripController;
import controller.MetricController;
import controller.TripController;
import model.timetable.TimeTable;
import model.vasttrafik_api.response_classes.name.NameResponse;
import view.textview.textcmds.MockTimeTable;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GraphicView extends BaseView implements ChangeListener, ActionListener, ListSelectionListener {
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem m1, m2;
    private JFrame frame;
    private JButton button;
    private JButton select;
    private JButton select1;
    private JSlider slider;

    private IMetricController metricController;
    private ITripController tripController;

    public GraphicView(TimeTable timeTable) {
        super(timeTable);
        metricController = new MetricController();
        tripController = new TripController(metricController);
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
        panel1.setPreferredSize(new Dimension(420,500));
        panel1.setBackground(Color.green);
        panel1.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel1.setLayout(new GridLayout(0,1));
        frame.add(panel1, BorderLayout.CENTER);


        String[] locations = new String[10];
        locations[0] = "Chalmers";
        locations[1] = "Lindholmen";
        locations[2] = "Korsvägen";
        locations[3] = "Brunnsparken";
        locations[4] = "Frölundatorg";
        locations[5] = "Chalmers";
        locations[6] = "Lindholmen";
        locations[7] = "Korsvägen";
        locations[8] = "Brunnsparken";
        locations[9] = "Frölundatorg";



        //Start
        JList list1 = new JList(locations);
        list1.setVisibleRowCount(5);

        //Destination
        JList list2 = new JList(locations);
        list2.setVisibleRowCount(5);

        JLabel start = new JLabel("Start");
        start.setHorizontalAlignment(JLabel.CENTER);
        panel1.add(start);

        JScrollPane scrollPane = new JScrollPane(list1);
        JTextField textField = new JTextField();
        textField.getDocument().addDocumentListener(new SearchBoxDocumentListener(scrollPane, textField));
        panel1.add(textField);

        //Scroll
        scrollPane.setViewportView(list1);
        list1.setLayoutOrientation(JList.VERTICAL);
        panel1.add(scrollPane);

        JButton select1 = new JButton("Välj");
        select1.addActionListener(this);
        panel1.add(select1);

        //Label
        JLabel destination = new JLabel("Destination");
        destination.setHorizontalTextPosition(JLabel.CENTER);
        destination.setHorizontalAlignment(JLabel.CENTER);
        panel1.add(destination);

        //Scroll 2
        JScrollPane scrollPane2 = new JScrollPane(list2);
        scrollPane2.setViewportView(list2);
        list2.setLayoutOrientation(JList.VERTICAL);
        panel1.add(scrollPane2);

        list1.addListSelectionListener(this);

        JButton select = new JButton("Välj");
        select.addActionListener(this);
        panel1.add(select);

        //Panel 2
        JPanel panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(0,50));
        panel2.setBackground(Color.BLUE);
        frame.add(panel2, BorderLayout.AFTER_LAST_LINE);

        //Label
        JLabel label = new JLabel("Välj din säkerhets faktor");
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        panel1.add(label);

        //Slider
        slider = new JSlider(JSlider.HORIZONTAL,0,10,5);
        slider.addChangeListener(this);
        slider.setMinorTickSpacing(1);
        slider.setMajorTickSpacing(2);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        panel1.add(slider);

        //button
        button = new JButton("Sök");
        button.addActionListener(this);
        panel2.add(button);

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
    public static void main(String[] args){
        TimeTable timeTable = new MockTimeTable();
        BaseView userInterface = new GraphicView(timeTable);
        userInterface.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            frame.dispose();
            System.out.println("Button pressed");
            NewWindow myWindow = new NewWindow();
        }


    }

    public void stateChanged(ChangeEvent e){
        System.out.println("Slider set to " + slider.getValue());
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
       // if(e.getSource()==list1){}
    }

    class SearchBoxDocumentListener implements DocumentListener {
        private JScrollPane jScrollPane;
        private JTextField jTextField;

        public SearchBoxDocumentListener(JScrollPane jScrollPane, JTextField jTextField) {
            this.jScrollPane = jScrollPane;
            this.jTextField = jTextField;
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            updateList();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {

        }

        private void updateList() {
            //JList jList =
            NameResponse nameResponse = tripController.findNames(jTextField.getText());
            JList jList = new JList(nameResponse.getLocationList().getStopLocation().toArray());

            jScrollPane.setViewportView(jList);
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
        }
    }
}
