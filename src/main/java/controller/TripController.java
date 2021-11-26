package controller;

import model.vasttrafik_api.Auth;
import model.vasttrafik_api.TravelSearch;
import model.vasttrafik_api.response_classes.Token;
import model.vasttrafik_api.response_classes.name.NameResponse;
import model.vasttrafik_api.response_classes.trip.TripItem;
import model.vasttrafik_api.response_classes.trip.TripResponse;

import java.util.List;

public class TripController implements ITripController {
    private MetricController m;

    public TripController(MetricController metricController) {
        this.m = metricController;
    }

    @Override
    public TripResponse findTrip(String sourceId, String destinationId) {
        Token token = Auth.getToken();

        TripResponse tripResponse = TravelSearch.getTrip(sourceId, destinationId,
                m.getMetric(Metric.VIA_ID), m.getMetric(Metric.DATE), m.getMetric(Metric.TIME),
                m.getMetric(Metric.SEARCH_FOR_ARRIVAL), m.getMetric(Metric.WHEEL_CHAIR_SPACE),
                m.getMetric(Metric.STROLLER_SPACE), m.getMetric(Metric.LOW_FLOOR),
                m.getMetric(Metric.RAMP_OR_LIFT), m.getMetric(Metric.MAX_WALK_DISTANCE), null,
                m.getMetric(Metric.ADDITIONAL_CHANGE_TIME), token);

        tripResponse.getTripList().calculateScores();

        List<TripItem> trips = tripResponse.getTripList().getTrips();
        trips.sort(new TripItem.TripComparator());

        return tripResponse;
    }

    @Override
    public NameResponse findNames(String query) {
        Token token = Auth.getToken();
        return TravelSearch.getName(query, token);
    }
}
