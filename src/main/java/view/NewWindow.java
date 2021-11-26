package view;

import javax.swing.*;
import java.awt.*;

public class NewWindow {
    JFrame frame = new JFrame("Västtrafik");
    JLabel label = new JLabel();

    NewWindow(){
        //Label
        label.setText("Välkommen");
        label.setBounds(0,100,500,250);
        label.setFont(new Font(null, Font.BOLD,25));
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);

        frame.add(label);


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
}
