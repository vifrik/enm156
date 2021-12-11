package view.graphicview;

import controller.ITripController;

import javax.swing.*;
import java.awt.*;

class SearchSection {
    public static final int STD_HEIGHT = 50;
    public static final int STD_WIDTH = 50;

    JLabel label;
    JScrollPane scrollPane;
    JTextField textField;

    public SearchSection(JPanel panel, ITripController tripController, String name) {
        label = new JLabel(name);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setForeground(Color.decode("#284B63"));
        label.setFont(new Font("Sans-Serif", Font.PLAIN, 18));

        textField = new JTextField();
        scrollPane = new JScrollPane();

        var documentListener = new SearchBoxDocumentListener(tripController, this);
        textField.getDocument().addDocumentListener(documentListener);
        textField.setPreferredSize(new Dimension(400, SearchSection.STD_HEIGHT / 2));
        scrollPane.setPreferredSize(new Dimension(400, SearchSection.STD_HEIGHT * 2));

        panel.add(label);
        panel.add(textField);
        panel.add(scrollPane);
    }
}
