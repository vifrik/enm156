package view;

import model.timetable.MockTimeTable;
import model.timetable.TimeTable;

import javax.swing.*;

public class GraphicView extends BaseView{
    private JMenuBar mb;

    private JMenu x;

    private JMenuItem m1, m2, m3;

    // create a frame
    private JFrame f;

    private JButton b;

    private JSlider s;

    public GraphicView(TimeTable timeTable) {
        super(timeTable);
    }

    @Override
    protected void setup() {
        // create a frame
        f = new JFrame("Menu demo");

        // create a menubar
        mb = new JMenuBar();

        JButton b= new JButton("Sök resa");
        b.setBounds(50,100,95,30);
        f.add(b);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);

        JSlider s = new JSlider(0,10);

        // create a menu
        x = new JMenu("Menu");

        // create menuitems
        m1 = new JMenuItem("MenuItem1");
        m2 = new JMenuItem("MenuItem2");
        m3 = new JMenuItem("MenuItem3");

        // add menu items to menu
        x.add(m1);
        x.add(m2);
        x.add(m3);

        // add menu to menu bar
        mb.add(x);

        // add menubar to frame
        f.setJMenuBar(mb);

        // set the size of the frame
        f.setSize(500, 500);
        f.setVisible(true);
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
}
