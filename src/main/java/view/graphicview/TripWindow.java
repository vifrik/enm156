package view.graphicview;

import controller.ITripController;
import model.vasttrafik_api.response_classes.name.StopLocationItem;
import model.vasttrafik_api.response_classes.trip.LegItem;
import model.vasttrafik_api.response_classes.trip.TripItem;
import model.vasttrafik_api.response_classes.trip.TripResponse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class TripWindow {
    JFrame frame = new JFrame("Resvägar");
    ITripController tripController;

    private void addTrip(JPanel panel, LegItem sourceLeg, LegItem destLeg, TripItem tripItem,
                         StopLocationItem source, StopLocationItem dest) {
        JPanel subPanel = new JPanel();
        subPanel.setBackground(Color.decode("#284B63"));
        subPanel.setPreferredSize(new Dimension(420, 60));

        GridLayout gridLayout = new GridLayout(0, 1);
        subPanel.setLayout(gridLayout);

        JLabel sourceLabel = new JLabel("%s - %s".formatted(sourceLeg.getOrigin().getTime(),sourceLeg.getOrigin().getName()));
        sourceLabel.setForeground(Color.decode("#F4F9E9"));

        JLabel destLabel = new JLabel("%s - %s".formatted(destLeg.getDestination().getTime(),destLeg.getDestination().getName()));
        destLabel.setForeground(Color.decode("#F4F9E9"));

        JLabel weight = new JLabel("Vikt (egen kvantitet): %s".formatted(tripItem.getScore()));
        weight.setForeground(Color.decode("#F4F9E9"));

        subPanel.add(sourceLabel);
        subPanel.add(destLabel);
        subPanel.add(weight);

        subPanel.addMouseListener(new PanelMouseListener(subPanel, tripItem, source, dest));

        panel.validate();
        panel.add(subPanel);
    }

    public TripWindow(TripResponse tripResponse, StopLocationItem source, StopLocationItem dest, ITripController tripController) {
        this.tripController = tripController;

        GridLayout gridLayout = new GridLayout(0, 1, 0, 10);
        JPanel panel = new JPanel(gridLayout);
        //panel.setPreferredSize(new Dimension(420, 500));
        panel.setBackground(Color.decode("#B4B8AB"));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));

        JLabel header = new JLabel("%s -> %s".formatted(source.getName(), dest.getName()));
        panel.add(header);

        for (TripItem tripItem : tripResponse.getTripList().getTrips()) {
            if (tripItem.getTimeScore() <= 0) continue;
            List<LegItem> legItemList = tripItem.getLeg();
            LegItem firstLegItem = legItemList.get(0);
            LegItem lastLegItem = legItemList.get(legItemList.size() - 1);
            addTrip(panel, firstLegItem, lastLegItem, tripItem, source, dest);
        }

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    class PanelMouseListener implements MouseListener {
        private final JPanel jPanel;
        private final TripItem tripItem;
        private final StopLocationItem source;
        private final StopLocationItem dest;

        public PanelMouseListener(JPanel jPanel, TripItem tripItem, StopLocationItem source, StopLocationItem dest) {
            this.jPanel = jPanel;
            this.tripItem = tripItem;
            this.source = source;
            this.dest = dest;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            TripDetailWindow tripDetailWindow = new TripDetailWindow(tripItem, source, dest, tripController);
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
