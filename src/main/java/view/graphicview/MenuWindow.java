package view.graphicview;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuWindow implements  ChangeListener, ActionListener {
    JFrame frame;
    JSlider changeTimeSlider;
    JButton helpButton, backButton;
    private final GraphicView graphicView;

    MenuWindow(GraphicView graphicView){
        this.graphicView = graphicView;

        createFrame();
        createPanel();
        createChangeTimeSlider();
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

    private void createChangeTimeSlider() {
        changeTimeSlider = new JSlider(JSlider.HORIZONTAL,5,60,5);
        changeTimeSlider.setBounds(200,100,180,50);
        changeTimeSlider.addChangeListener(this);
        changeTimeSlider.setMinorTickSpacing(1);
        changeTimeSlider.setMajorTickSpacing(5);
        changeTimeSlider.setPaintTicks(true);
        changeTimeSlider.setPaintLabels(true);

        var label = new JLabel();
        label.setText("Bytestid");
        label.setBounds(100,100,100,50);
        label.setFont(new Font(null, Font.PLAIN,15));
        label.setHorizontalTextPosition(JLabel.LEFT);
        label.setVerticalAlignment(JLabel.CENTER);

        frame.add(changeTimeSlider);
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
