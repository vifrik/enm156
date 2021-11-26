package model.vasttrafik_api.response_classes.name;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class NameResponse{

    @SerializedName("serverdate")
    private String serverdate;

    @SerializedName("errorText")
    private String errorText;

    @SerializedName("servertime")
    private String servertime;

    @SerializedName("StopLocation")
    private List<StopLocationItem> stopLocation;

    @SerializedName("noNamespaceSchemaLocation")
    private String noNamespaceSchemaLocation;

    @SerializedName("error")
    private String error;

    @SerializedName("CoordLocation")
    private List<CoordLocationItem> coordLocation;

    public String getServerdate(){
        return serverdate;
    }

    public String getErrorText(){
        return errorText;
    }

    public String getServertime(){
        return servertime;
    }

    public List<StopLocationItem> getStopLocation(){
        return stopLocation;
    }

    public String getNoNamespaceSchemaLocation(){
        return noNamespaceSchemaLocation;
    }

    public String getError(){
        return error;
    }

    public List<CoordLocationItem> getCoordLocation(){
        return coordLocation;
    }
}