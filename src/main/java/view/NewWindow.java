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
    JButton button;

    NewWindow(){
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
        slider = new JSlider(JSlider.HORIZONTAL,0,10,5);
        slider.setBounds(100,150,300,200);
        slider.addChangeListener((ChangeListener) this);
        slider.setMinorTickSpacing(1);
        slider.setMajorTickSpacing(2);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        frame.add(slider);

        //Button
        button = new JButton("Hjälp");
        button.setBounds(200,350,100,40);
        button.addActionListener(this);
        frame.add(button);

        //Pop-up

        //Frame
        frame.setResizable(false);
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==menuItem){
            frame.dispose();
            //GraphicView graphicView = new GraphicView();
        }
        if(e.getSource()==button){
            JOptionPane optionPane= new JOptionPane();
            JOptionPane.showMessageDialog(frame,"Genom att ställa in säkerhetsfaktorn väljer du hur säker din resa ska vara samt hur mycket du är redo att riskera för snabbhet");

        }
    }
}
