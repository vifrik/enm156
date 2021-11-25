package view;

import model.timetable.MockTimeTable;
import model.timetable.TimeTable;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicView extends BaseView implements ChangeListener, ActionListener{
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem m1, m2;
    private JFrame frame;
    private JButton button;
    private JSlider slider;
    private JLabel label;
    static final int min = 0;
    static final int max = 10;
    static final int start = 5;

    public GraphicView(TimeTable timeTable) {
        super(timeTable);
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

        //Menu
        JMenuItem i1,i2,i3;
        menuBar = new JMenuBar();
        menu = new JMenu("Menu");
        i1 = new JMenuItem("1");
        i2 = new JMenuItem("2");
        i3 = new JMenuItem("3");
        menu.add(i1); menu.add(i2); menu.add(i3);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);
        frame.add(menuBar);

        //Panel
        JPanel panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(400,150));
        panel1.setBackground(Color.green);
        panel1.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel1.setLayout(new GridLayout(0,1));
        frame.add(panel1, BorderLayout.CENTER);

        //Panel 2
        JPanel panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(0,50));
        panel2.setBackground(Color.BLUE);
        frame.add(panel2, BorderLayout.AFTER_LAST_LINE);

        //Label
        label = new JLabel("Välj din säkerhets faktor");
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        panel1.add(label);

        //Slider
        slider = new JSlider(JSlider.HORIZONTAL,min,max,start);
        slider.addChangeListener((ChangeListener) this);
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
}
