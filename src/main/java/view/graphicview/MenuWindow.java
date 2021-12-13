package view.graphicview;

import controller.Weights;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuWindow implements  ChangeListener, ActionListener {
    JFrame frame;
    JSlider changeTimeSlider, changesSlider, centralSlider;
    JButton helpButton, backButton;
    private final GraphicView graphicView;

    MenuWindow(GraphicView graphicView){
        this.graphicView = graphicView;

        createFrame();
        createPanel();

        changeTimeSlider = new JSlider(JSlider.HORIZONTAL,5,60,5);
        changesSlider = new JSlider(JSlider.HORIZONTAL,0,10,5);
        centralSlider = new JSlider(JSlider.HORIZONTAL,0,10,5);

        addSlider(changeTimeSlider, 200, 50, "Bytestid");
        addSlider(changesSlider, 200, 125, "Undvik byten");
        addSlider(centralSlider, 200, 200, "Undvik central");

        createControlButtons();
    }

    private void createFrame() {
        frame = new JFrame("Västtrafik");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon image = new ImageIcon("buss.png");
        frame.setIconImage(image.getImage());
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void createPanel() {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(500, 500));
        frame.add(panel, BorderLayout.AFTER_LAST_LINE);
    }

    private void addSlider(JSlider slider, int x, int y, String text) {
        //slider = new JSlider(JSlider.HORIZONTAL,5,60,5);
        slider.setBounds(x,y,180,50);
        slider.addChangeListener(this);
        slider.setMinorTickSpacing(1);
        slider.setMajorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        var label = new JLabel();
        label.setText(text);
        label.setBounds(x-150,y,100,50);
        label.setFont(new Font(null, Font.PLAIN,15));
        label.setHorizontalTextPosition(JLabel.LEFT);
        label.setVerticalAlignment(JLabel.CENTER);

        frame.add(slider);
        frame.add(label);
    }

    private void createControlButtons() {
        helpButton = createButton("Hjälp", new Rectangle(200, 250, 100, 40));
        backButton = createButton("Tillbaka", new Rectangle(200, 300, 100, 40));
    }

    private JButton createButton(String title, Rectangle bounds) {
        var button = new JButton(title);
        button.setBounds(bounds);
        button.addActionListener(this);
        frame.add(button);
        return button;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == changeTimeSlider) {
            graphicView.metricController.setMetric("change-time", Integer.toString(changeTimeSlider.getValue()));
        }
        if (e.getSource() == changesSlider) {
            graphicView.tripController.setWeight(Weights.AVOID_CHANGES, changesSlider.getValue());
        }
        if (e.getSource() == centralSlider) {
            graphicView.tripController.setWeight(Weights.AVOID_CENTRAL, centralSlider.getValue());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== helpButton){
            JOptionPane.showMessageDialog(frame,"Bytestid: Minsta antalet minuter ett byte ska räknas ta");
        }
        if (e.getSource() == backButton) {
            graphicView.frame.setVisible(true);
            frame.dispose();
        }
    }
}
