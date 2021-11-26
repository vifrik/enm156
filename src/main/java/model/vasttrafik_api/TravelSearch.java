package model.vasttrafik_api;

import model.vasttrafik_api.response_classes.Token;
import model.vasttrafik_api.response_classes.departure_board.DepartureBoardResponse;
import model.vasttrafik_api.response_classes.journey_detail.JourneyDetailResponse;
import model.vasttrafik_api.response_classes.name.NameResponse;
import model.vasttrafik_api.response_classes.nearby_stops.NearbyStopsResponse;
import model.vasttrafik_api.response_classes.trip.TripResponse;
import okhttp3.Request;
import okhttp3.Response;

import java.util.HashMap;
import java.util.Map;

public class TravelSearch {
    public static NearbyStopsResponse getNearbyStations(double lon, double lat, Token token) {
        Map<String, String> auth = new HashMap<>();
        auth.put("Authorization", "Bearer " + token.getAccessToken());

        Map<String, String> params = new HashMap<>();
        params.put("originCoordLat", String.valueOf(lat));
        params.put("originCoordLong", String.valueOf(lon));

        Response response = Connection.sendRequest(
                "bin/rest.exe/v2/location.nearbystops",
                "GET", params, auth, null);

        return JSON.objFromJson(response, NearbyStopsResponse.class);
    }

    public static DepartureBoardResponse getDepartureBoard(String id, String date, String time, Token token) {
        Map<String, String> auth = new HashMap<>();
        auth.put("Authorization", "Bearer " + token.getAccessToken());

        Map<String, String> params = new HashMap<>();
        params.put("id", id);
        params.put("date", date);
        params.put("time", time);

        Response response = Connection.sendRequest("bin/rest.exe/v2/departureBoard", "GET", params, auth, null);

        return JSON.objFromJson(response, DepartureBoardResponse.class);
    }

    public static JourneyDetailResponse getJourneyDetail(String ref, Token token) {
        Map<String, String> auth = new HashMap<>();
        auth.put("Authorization", "Bearer " + token.getAccessToken());

        Request request = Connection.getRequest(ref, "GET", auth, null);

        Response response = Connection.sendRequest(request);

        return JSON.objFromJson(response, JourneyDetailResponse.class);
    }

    public static TripResponse getTrip(String originId, String destId,
                                       String viaId, String date, String time,
                                       String searchForArrival, String wheelChairSpace,
                                       String strollerSpace, String lowFloor,
                                       String rampOrLift, String maxWalkDist,
                                       String walkSpeed, String additionalChangeTime,
                                       String numTrips, Token token) {
        Map<String, String> auth = new HashMap<>();
        auth.put("Authorization", "Bearer " + token.getAccessToken());

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
        params.put("numTrips", numTrips);

        Response response = Connection.sendRequest("bin/rest.exe/v2/trip", "GET", params, auth, null);

        return JSON.objFromJson(response, TripResponse.class);
    }

    public static NameResponse getName(String searchName, Token token) {
        Map<String, String> auth = new HashMap<>();
        auth.put("Authorization", "Bearer " + token.getAccessToken());

        Map<String, String> params = new HashMap<>();
        params.put("input", searchName);

        Response response = Connection.sendRequest("bin/rest.exe/v2/location.name", "GET", params, auth, null);

        return JSON.objFromJson(response, NameResponse.class);
    }
}
