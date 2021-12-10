package view;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


public class NewWindow implements  ChangeListener, ActionListener {
    JFrame frame = new JFrame("Västtrafik");
    JLabel label = new JLabel();
    JSlider slider;
    JMenu menu;
    JMenuItem menuItem;
    JMenuBar menuBar;
    JButton helpButton, backButton;
    private final GraphicView graphicView;

    NewWindow(GraphicView graphicView){
        this.graphicView = graphicView;
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(0,50));
        panel.setBackground(Color.BLUE);
        frame.add(panel, BorderLayout.AFTER_LAST_LINE);

        //Menu
        menuBar = new JMenuBar();
        menu = new JMenu("Meny");
        menuBar.add(menu);

        menuItem = new JMenuItem("Sök",
                KeyEvent.VK_T);
        menuItem.addActionListener(this);
        menu.add(menuItem);
        frame.setJMenuBar(menuBar);



        //Label
        label.setText("Välj säkerhetsfaktor");
        label.setBounds(100,100,300,50);
        label.setFont(new Font(null, Font.PLAIN,15));
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        frame.add(label);


        //Slider
        slider = new JSlider(JSlider.HORIZONTAL,5,60,5);
        slider.setBounds(100,150,300,100);
        slider.addChangeListener(this);
        slider.setMinorTickSpacing(1);
        slider.setMajorTickSpacing(2);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        frame.add(slider);

        //Button
        helpButton = new JButton("Hjälp");
        helpButton.setBounds(200,250,100,40);
        helpButton.addActionListener(this);
        frame.add(helpButton);

        backButton = new JButton("Tillbaka");
        backButton.setBounds(200, 300, 100, 40);
        backButton.addActionListener(this);
        frame.add(backButton);

        //Pop-up

        //Frame
        //frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon image = new ImageIcon("buss.png");
        frame.setIconImage(image.getImage());
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        System.out.println("Slider set to " + slider.getValue());
        graphicView.metricController.setMetric("change-time", Integer.toString(slider.getValue()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==menuItem){
            frame.dispose();
            //GraphicView graphicView = new GraphicView();
        }
        if(e.getSource()== helpButton){
            JOptionPane optionPane= new JOptionPane();
            JOptionPane.showMessageDialog(frame,"Genom att ställa in säkerhetsfaktorn väljer du hur säker din resa ska vara samt hur mycket du är redo att riskera för snabbhet");
        }
        if (e.getSource() == backButton) {
            graphicView.frame.setVisible(true);
            frame.dispose();
        }


    }
}
