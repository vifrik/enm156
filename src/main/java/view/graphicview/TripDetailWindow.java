package view.graphicview;

import controller.ITripController;
import model.vasttrafik_api.response_classes.name.NameResponse;
import model.vasttrafik_api.response_classes.name.StopLocationItem;
import model.vasttrafik_api.response_classes.trip.LegItem;
import model.vasttrafik_api.response_classes.trip.TripItem;
import model.vasttrafik_api.response_classes.trip.TripResponse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TripDetailWindow {
    JFrame frame = new JFrame("Detaljer");
    ITripController tripController;

    private void addDetail(JPanel panel, LegItem legItem, StopLocationItem source, StopLocationItem dest) {
        JPanel subPanel = new JPanel();
        subPanel.setBackground(Color.decode("#284B63"));
        subPanel.setPreferredSize(new Dimension(420, 60));

        GridLayout gridLayout = new GridLayout(0, 1);
        subPanel.setLayout(gridLayout);

        if (!(legItem.getType().equals("WALK") && legItem.getOrigin().getName().equals(legItem.getDestination().getName()))) {
            JLabel typeLabel = new JLabel("[%s] %s: %s".formatted(legItem.getType(), legItem.getSname(), legItem.getDirection()));
            typeLabel.setForeground(Color.decode("#F4F9E9"));

            JLabel sourceLabel = new JLabel("%s - %s".formatted(legItem.getOrigin().getTime(),legItem.getOrigin().getName()));
            sourceLabel.setForeground(Color.decode("#F4F9E9"));

            JLabel destLabel = new JLabel("%s - %s".formatted(legItem.getDestination().getTime(),legItem.getDestination().getName()));
            destLabel.setForeground(Color.decode("#F4F9E9"));

            if (legItem.getFgColor() != null) {
                typeLabel.setForeground(Color.decode(legItem.getFgColor()));
                sourceLabel.setForeground(Color.decode(legItem.getFgColor()));
                destLabel.setForeground(Color.decode(legItem.getFgColor()));
            }
            if (legItem.getBgColor() != null) subPanel.setBackground(Color.decode(legItem.getBgColor()));

            subPanel.add(typeLabel);
            subPanel.add(sourceLabel);
            subPanel.add(destLabel);
        } else {
            JLabel waitLabel = new JLabel("[WAIT] %s - %s | %s".formatted(legItem.getOrigin().getTime(),
                    legItem.getDestination().getTime(),
                    legItem.getOrigin().getName()));
            waitLabel.setForeground(Color.decode("#F4F9E9"));

            subPanel.add(waitLabel);
        }

        subPanel.addMouseListener(new PanelMouseListener(subPanel, legItem, source, dest));

        panel.validate();
        panel.add(subPanel);
    }

    public TripDetailWindow(TripItem tripItem, StopLocationItem source, StopLocationItem dest, ITripController tripController) {
        this.tripController = tripController;

        GridLayout gridLayout = new GridLayout(0, 1, 0, 10);
        JPanel panel = new JPanel(gridLayout);
        panel.setBackground(Color.decode("#B4B8AB"));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));

        JLabel header = new JLabel("Resedetaljer %s -> %s".formatted(source.getName(), dest.getName()));
        panel.add(header);

        for (LegItem legItem : tripItem.getLeg()) {
            addDetail(panel, legItem, source, dest);
        }

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    class PanelMouseListener implements MouseListener {
        private final JPanel jPanel;
        private final LegItem legItem;
        private StopLocationItem source;
        private final StopLocationItem dest;

        public PanelMouseListener(JPanel jPanel, LegItem legItem, StopLocationItem source, StopLocationItem dest) {
            this.jPanel = jPanel;
            this.legItem = legItem;
            this.source = source;
            this.dest = dest;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            NameResponse nameResponse = tripController.findNames(legItem.getOrigin().getName());
            source = nameResponse.getLocationList().getStopLocation().get(0);

            TripResponse trip = tripController.findTrip(legItem.getOrigin().getId(), dest.getId(), legItem.getOrigin().getTime());
            TripWindow tripWindow = new TripWindow(trip, source, dest, legItem.getOrigin().getTime(), tripController);
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
