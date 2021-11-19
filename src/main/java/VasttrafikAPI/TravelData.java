package VasttrafikAPI;

import VasttrafikAPI.ResponseClasses.DepartureBoard.DepartureBoardResponse;
import VasttrafikAPI.ResponseClasses.JourneyDetail.JourneyDetailResponse;
import VasttrafikAPI.ResponseClasses.NearbyStops.NearbyStopsResponse;
import VasttrafikAPI.ResponseClasses.Token;
import VasttrafikAPI.ResponseClasses.Trip.TripResponse;
import okhttp3.Request;
import okhttp3.Response;

import java.util.HashMap;
import java.util.Map;

public class TravelData {
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

    public static TripResponse getTrip(String originId, String destId, Token token) {
        Map<String, String> auth = new HashMap<>();
        auth.put("Authorization", "Bearer " + token.getAccessToken());

        Map<String, String> params = new HashMap<>();
        params.put("originId", originId);
        params.put("destId", destId);

        Response response = Connection.sendRequest("bin/rest.exe/v2/trip", "GET", params, auth, null);

        return JSON.objFromJson(response, TripResponse.class);
    }
}
