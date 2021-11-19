import VasttrafikAPI.Auth;
import VasttrafikAPI.ResponseClasses.Token;
import VasttrafikAPI.ResponseClasses.Trip.TripResponse;
import VasttrafikAPI.TravelData;

public class ApiTripTest {
    public static void main(String[] args) {
        Token token = Auth.getToken();

        TripResponse nearbyStations = TravelData.getTrip("9022014001960001", "9021014004945000", token);

        System.out.println(nearbyStations);
    }
}
