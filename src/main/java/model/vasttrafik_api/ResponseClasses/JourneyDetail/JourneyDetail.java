package model.vasttrafik_api.responseClasses.journeyDetail;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JourneyDetail {

    @SerializedName("serverdate")
    private String serverdate;

    @SerializedName("JourneyType")
    private List<JourneyTypeItem> journeyTypes;

    @SerializedName("JourneyId")
    private JourneyId journeyId;

    @SerializedName("Stop")
    private List<StopItem> stops;

    @SerializedName("Color")
    private Color color;

    @SerializedName("GeometryRef")
    private GeometryRef geometryRef;

    @SerializedName("servertime")
    private String servertime;

    @SerializedName("noNamespaceSchemaLocation")
    private String noNamespaceSchemaLocation;

    @SerializedName("Direction")
    private List<DirectionItem> direction;

    @SerializedName("JourneyName")
    private List<JourneyNameItem> journeyNames;

    public String getServerdate() {
        return serverdate;
    }

    public List<JourneyTypeItem> getJourneyTypes() {
        return journeyTypes;
    }

    public JourneyId getJourneyId() {
        return journeyId;
    }

    public List<StopItem> getStops() {
        return stops;
    }

    public Color getColor() {
        return color;
    }

    public GeometryRef getGeometryRef() {
        return geometryRef;
    }

    public String getServertime() {
        return servertime;
    }

    public String getNoNamespaceSchemaLocation() {
        return noNamespaceSchemaLocation;
    }

    public List<DirectionItem> getDirection() {
        return direction;
    }

    public List<JourneyNameItem> getJourneyNames() {
        return journeyNames;
    }
}