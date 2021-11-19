import VasttrafikAPI.Auth;
import VasttrafikAPI.ResponseClasses.Token;
import VasttrafikAPI.ResponseClasses.Trip.TripItem;
import VasttrafikAPI.ResponseClasses.Trip.TripResponse;
import VasttrafikAPI.TravelData;

import java.util.List;

public class ApiTripTest {
    public static void main(String[] args) {

        Token token = Auth.getToken();

        TripResponse tripResponse = TravelData.getTrip("9022014001960001", "9021014004945000",
                null, null, null, null, null, null,
                null, null, null, null, null, "20",
                token);

        tripResponse.getTripList().calculateScores();

        List<TripItem> trips = tripResponse.getTripList().getTrips();
        trips.sort(new TripItem.TripComparator());

        System.out.println(tripResponse);
    }
}
