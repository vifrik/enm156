package controller;

import model.trip.Trip;

import java.util.List;

public interface ITripController {
    public Trip findTrip(String source, String destination);
}
