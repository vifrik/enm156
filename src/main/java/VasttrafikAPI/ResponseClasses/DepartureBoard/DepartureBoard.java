package VasttrafikAPI.ResponseClasses.DepartureBoard;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DepartureBoard {

    @SerializedName("serverdate")
    private String serverdate;

    @SerializedName("Departure")
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