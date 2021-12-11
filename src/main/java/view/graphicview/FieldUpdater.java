package view.graphicview;

import controller.TripController;

import javax.swing.*;

class FieldUpdater extends Thread {
    boolean isSearching;
    boolean isRunning;
    String query;
    TripController tripController;
    JTextField field;
    JScrollPane pane;

    public FieldUpdater(TripController tripController, JTextField field, JScrollPane pane) {
        this.tripController = tripController;
        this.field = field;
        this.pane = pane;

        isRunning = true;
        isSearching = false;
        query = "";
    }

    @Override
    public synchronized void run() {
        while (isRunning) {
            updateField();
            awaitQuery();
        }
    }

    public void queryField(String query) {
        this.query = query;
        isSearching = true;
        this.notifyAll();
    }

    public void shutdownThread() {
        isRunning = false;
        this.notifyAll();
    }

    private void awaitQuery() {
        while (!isSearching && isRunning) {
            try {
                wait();
            } catch (InterruptedException ignored) {
            }
            ;
        }
    }

    private void updateField() {
        if (!isRunning || !isSearching)
            return;

        var nameResponse = tripController.findNames(query);

        var jList = new JList<>(nameResponse.getLocationList().getStopLocation().toArray());
        pane.setViewportView(jList);
        isSearching = false;
    }
}
