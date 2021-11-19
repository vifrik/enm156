import VasttrafikAPI.Auth;
import VasttrafikAPI.ResponseClasses.DepartureBoard.DepartureBoardResponse;
import VasttrafikAPI.ResponseClasses.DepartureBoard.DepartureItem;
import VasttrafikAPI.ResponseClasses.JourneyDetail.JourneyDetailResponse;
import VasttrafikAPI.ResponseClasses.JourneyDetail.StopItem;
import VasttrafikAPI.ResponseClasses.NearbyStops.LocationList;
import VasttrafikAPI.ResponseClasses.NearbyStops.NearbyStopsResponse;
import VasttrafikAPI.ResponseClasses.NearbyStops.StopLocationItem;
import VasttrafikAPI.ResponseClasses.Token;
import VasttrafikAPI.ResponseClasses.Trip.LegItem;
import VasttrafikAPI.ResponseClasses.Trip.TripItem;
import VasttrafikAPI.TravelData;
import org.jgrapht.GraphPath;
import org.jgrapht.graph.DefaultWeightedEdge;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ApiTest {
    public static void main(String[] args) {
        Token token = Auth.getToken();

        NearbyStopsResponse nearbyStations = TravelData.getNearbyStations(11.973372, 57.689953, token);
        LocationList locationList = nearbyStations.getLocationList();

        for (StopLocationItem stopLocationItem : locationList.getStopLocations()) {
            System.out.println(stopLocationItem);
        }

        StopLocationItem stop = locationList.getStopLocations().get(0);
        String stopId = stop.getId();

        DepartureBoardResponse departureBoardResponse = TravelData.getDepartureBoard(stopId, "2021-11-17", "23:54", token);
        DepartureItem departureItem = departureBoardResponse.getDepartureBoard().getDepartures().get(0);
        String refUrl = departureItem.getJourneyDetailRef().getRef();

        JourneyDetailResponse journeyDetailResponse = TravelData.getJourneyDetail(refUrl, token);

        for (StopItem stopItem : journeyDetailResponse.getJourneyDetail().getStops()) {
            System.out.println(stopItem.getName());
        }

    }
}
