import model.vasttrafik_api.Auth;
import model.vasttrafik_api.StationWeight;
import model.vasttrafik_api.TravelData;
import model.vasttrafik_api.responseClasses.Token;
import model.vasttrafik_api.responseClasses.name.NameResponse;
import model.vasttrafik_api.responseClasses.trip.TripItem;
import model.vasttrafik_api.responseClasses.trip.TripResponse;
import model.vasttrafik_api.responseClasses.v3.token.TokenV3;

import java.util.List;

public class ApiTripTest {
    public static String toStringOrNull(Integer n) {
        if (n == null) return null;
        return n.toString();
    }

    public static TripResponse getRoutes(String from, String to, Integer walkSpeed, Integer additionalChangeTime) {
        Token token = Auth.getToken();
        TokenV3 tokenV3 = Auth.getTokenV3();

        NameResponse nameResponse = TravelData.getName(from, token);
        String idFrom = nameResponse.getLocationList().getStopLocation().get(0).getId();

        nameResponse = TravelData.getName(to, token);
        String idTo = nameResponse.getLocationList().getStopLocation().get(0).getId();

        TripResponse tripResponse = TravelData.getTrip(idFrom, idTo,
                null, null, null, null, null, null,
                null, null, null, toStringOrNull(walkSpeed), toStringOrNull(additionalChangeTime), "20",
                token);

        tripResponse.getTripList().calculateScores();

        List<TripItem> trips = tripResponse.getTripList().getTrips();
        trips.sort(new TripItem.TripComparator());

        return tripResponse;
    }

    public static void main(String[] args) {
        StationWeight.setup();

        TripResponse tripResponse = getRoutes("Chalmers", "Bergkristallsgatan", 100, 0);

        System.out.println(tripResponse);
    }
}
