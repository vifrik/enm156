package controller;

import model.vasttrafik_api.response_classes.departure_board.DepartureBoardResponse;
import model.vasttrafik_api.response_classes.name.NameResponse;
import model.vasttrafik_api.response_classes.trip.TripResponse;

public interface ITripController {
    public TripResponse findTrip(String sourceId, String destinationId);
    public TripResponse findTrip(String sourceId, String destinationId, String time);

    public NameResponse findNames(String query);

    public DepartureBoardResponse findDepartures(String id);
}
