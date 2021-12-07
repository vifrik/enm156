package model.vasttrafik_api.response_classes.departure_board;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import model.vasttrafik_api.response_classes.AlwaysListTypeAdapterFactory;

import java.util.List;

public class DepartureBoard {

    @SerializedName("serverdate")
    private String serverdate;

    @SerializedName("Departure")
    @JsonAdapter(AlwaysListTypeAdapterFactory.class)
    private List<DepartureItem> departures;

    @SerializedName("servertime")
    private String servertime;

    @SerializedName("noNamespaceSchemaLocation")
    private String noNamespaceSchemaLocation;

    public String getServerdate() {
        return serverdate;
    }

    public List<DepartureItem> getDepartures() {
        return departures;
    }

    public String getServertime() {
        return servertime;
    }

    public String getNoNamespaceSchemaLocation() {
        return noNamespaceSchemaLocation;
    }
}