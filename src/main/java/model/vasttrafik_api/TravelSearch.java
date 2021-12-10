package model.vasttrafik_api;

import model.vasttrafik_api.response_classes.departure_board.DepartureBoardResponse;
import model.vasttrafik_api.response_classes.name.NameResponse;
import model.vasttrafik_api.response_classes.trip.TripResponse;
import okhttp3.Response;

import java.util.HashMap;
import java.util.Map;

public class TravelSearch {
    private static final String NUM_TRIPS = "20";
    private final Auth auth;

    public TravelSearch() {
        auth = new Auth();
    }

    public TripResponse getTrip(String originId, String destId,
                                String viaId, String date, String time,
                                String searchForArrival, String wheelChairSpace,
                                String strollerSpace, String lowFloor,
                                String rampOrLift, String maxWalkDist,
                                String walkSpeed, String additionalChangeTime) {

        Map<String, String> params = new HashMap<>();
        params.put("originId", originId);
        params.put("destId", destId);
        params.put("viaId", viaId);
        params.put("date", date);
        params.put("time", time);
        params.put("searchForArrival", searchForArrival);
        params.put("wheelChairSpace", wheelChairSpace);
        params.put("strollerSpace", strollerSpace);
        params.put("lowFloor", lowFloor);
        params.put("rampOrLift", rampOrLift);
        params.put("maxWalkDist", maxWalkDist);
        params.put("walkSpeed", walkSpeed);
        params.put("additionalChangeTime", additionalChangeTime);
        params.put("numTrips", NUM_TRIPS);

        Response response = Connection.sendRequest("https", "api.vasttrafik.se",
                "bin/rest.exe/v2/trip", "GET", params, null, null, auth);

        return JSON.objFromJson(response, TripResponse.class);
    }

    public DepartureBoardResponse getDepartures(String id) {
        Map<String, String> params = new HashMap<>();
        params.put("id", id);

        Response response = Connection.sendRequest("https", "api.vasttrafik.se",
                "bin/rest.exe/v2/departureBoard", "GET", params, null, null, auth);

        return JSON.objFromJson(response, DepartureBoardResponse.class);
    }

    public NameResponse getName(String searchName) {
        Map<String, String> params = new HashMap<>();
        params.put("input", searchName);

        Response response = Connection.sendRequest("https", "api.vasttrafik.se",
                "bin/rest.exe/v2/location.name", "GET", params, null, null, auth);

        return JSON.objFromJson(response, NameResponse.class);
    }
}
