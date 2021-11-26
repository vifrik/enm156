package controller;

import model.vasttrafik_api.response_classes.name.NameResponse;
import model.vasttrafik_api.response_classes.trip.TripResponse;

public interface ITripController {
    public TripResponse findTrip(String sourceId, String destinationId);

    public NameResponse findNames(String query);
}
