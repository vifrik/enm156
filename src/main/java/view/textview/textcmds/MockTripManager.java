package view.textview.textcmds;

import controller.ITripController;
import model.vasttrafik_api.response_classes.name.NameResponse;
import model.vasttrafik_api.response_classes.trip.TripResponse;

public class MockTripManager implements ITripController {
    @Override
    public TripResponse findTrip(String sourceId, String destinationId) {
        return null;
    }

    @Override
    public NameResponse findNames(String query) {
        return null;
    }
}
