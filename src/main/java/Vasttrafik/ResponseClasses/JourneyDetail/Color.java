package Vasttrafik.ResponseClasses.JourneyDetail;

import com.google.gson.annotations.SerializedName;

public class Color{

    @SerializedName("fgColor")
    private String fgColor;

    @SerializedName("bgColor")
    private String bgColor;

    @SerializedName("stroke")
    private String stroke;

    public String getFgColor(){
        return fgColor;
    }

    public String getBgColor(){
        return bgColor;
    }

    public String getStroke(){
        return stroke;
    }
}