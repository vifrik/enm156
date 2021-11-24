package vasttrafikAPI;

import vasttrafikAPI.responseClasses.stationResponse.StationResponse;
import vasttrafikAPI.responseClasses.stationResponse.StopLocationItem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class StationWeight {
    public static final Map<String, Integer> weights = new HashMap<>();

    public static void setup() {
        try {
            String stationsJson = Files.readString(Path.of("data/stations.json"));
            StationResponse stationResponse = JSON.objFromJson(stationsJson, StationResponse.class);

            for (StopLocationItem stopLocationItem : stationResponse.getLocationList().getStopLocation()) {
                if (!weights.containsKey(stopLocationItem.getName())) {
                    weights.put(stopLocationItem.getName(), Integer.parseInt(stopLocationItem.getWeight()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, Integer> getWeights() {
        return weights;
    }
}
