package view.graphicview;

import controller.ITripController;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

record SearchBoxDocumentListener(ITripController tripController, SearchSection section) implements DocumentListener {

    @Override
    public void insertUpdate(DocumentEvent e) {
        updateScrollPane();

    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        updateScrollPane();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
    }

    private void updateScrollPane() {
        var query = section.textField.getText();
        EventQueue.invokeLater(() -> {
            setPaneContentToQueryResponse(query);
        });
    }

    private void setPaneContentToQueryResponse(String text) {
        var nameResponse = tripController.findNames(text);
        var locations = nameResponse.getLocationList().getStopLocation();
        if (!(locations == null || locations.isEmpty()))  {
            section.scrollPane.setViewportView(new JList<>(locations.toArray()));
        }
        else {
            section.scrollPane.setViewportView(null);
        }
    }
}
