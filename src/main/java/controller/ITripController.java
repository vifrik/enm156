package controller;

import model.trip.Trip;

import java.util.List;

public interface ITripController {
    public List<Trip> getTrips(String source, String destination);
}
