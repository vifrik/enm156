import VasttrafikAPI.Auth;
import VasttrafikAPI.ResponseClasses.Name.NameResponse;
import VasttrafikAPI.ResponseClasses.Token;
import VasttrafikAPI.ResponseClasses.Trip.TripItem;
import VasttrafikAPI.ResponseClasses.Trip.TripResponse;
import VasttrafikAPI.TravelData;

import java.util.List;

public class ApiTripTest {
    public static void main(String[] args) {

        Token token = Auth.getToken();

        NameResponse nameResponse = TravelData.getName("Chalmers", token);
        String idFrom = nameResponse.getLocationList().getStopLocation().get(0).getId();

        nameResponse = TravelData.getName("Ekmanska", token);
        String idTo = nameResponse.getLocationList().getStopLocation().get(0).getId();

        TripResponse tripResponse = TravelData.getTrip(idFrom, idTo,
                null, null, null, null, null, null,
                null, null, null, null, null, "20",
                token);

        tripResponse.getTripList().calculateScores();

        List<TripItem> trips = tripResponse.getTripList().getTrips();
        trips.sort(new TripItem.TripComparator());

        System.out.println(tripResponse);
    }
}
