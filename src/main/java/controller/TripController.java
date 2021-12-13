package controller;

import model.vasttrafik_api.TravelSearch;
import model.vasttrafik_api.response_classes.departure_board.DepartureBoardResponse;
import model.vasttrafik_api.response_classes.name.NameResponse;
import model.vasttrafik_api.response_classes.trip.TripItem;
import model.vasttrafik_api.response_classes.trip.TripResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TripController implements ITripController {
    private final IMetricController m;
    TravelSearch travelSearch;
    Map<Weights, Integer> weights = new HashMap<>();

    public TripController(IMetricController metricController) {
        this.m = metricController;
        travelSearch = new TravelSearch();
    }

    @Override
    public TripResponse findTrip(String sourceId, String destinationId, String time) {
        TripResponse tripResponse = travelSearch.getTrip(sourceId, destinationId,
                m.getMetric(Metric.VIA_ID), m.getMetric(Metric.DATE), time,
                m.getMetric(Metric.SEARCH_FOR_ARRIVAL), m.getMetric(Metric.WHEEL_CHAIR_SPACE),
                m.getMetric(Metric.STROLLER_SPACE), m.getMetric(Metric.LOW_FLOOR),
                m.getMetric(Metric.RAMP_OR_LIFT), m.getMetric(Metric.MAX_WALK_DISTANCE), null,
                m.getMetric(Metric.ADDITIONAL_CHANGE_TIME));

        tripResponse.getTripList().calculateScores(weights);

        List<TripItem> trips = tripResponse.getTripList().getTrips();
        trips.sort(new TripItem.TripComparator());

        return tripResponse;
    }

    @Override
    public TripResponse findTrip(String sourceId, String destinationId) {
        return findTrip(sourceId, destinationId, m.getMetric(Metric.TIME));
    }

    @Override
    public NameResponse findNames(String query) {
        return travelSearch.getName(query);
    }

    @Override
    public DepartureBoardResponse findDepartures(String id) {
        return travelSearch.getDepartures(id);
    }

    @Override
    public void setWeight(Weights weight, Integer value) {
        weights.put(weight, value);
    }
}
