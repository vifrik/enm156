package view.textview.textcmds;

import controller.ITripController;
import model.trip.Trip;

public class MockTripManager implements ITripController {
    @Override
    public Trip findTrip(String source, String destination) {
        return null;
    }
}
