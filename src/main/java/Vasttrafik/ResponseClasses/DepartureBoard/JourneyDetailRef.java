package Vasttrafik.ResponseClasses.DepartureBoard;

import com.google.gson.annotations.SerializedName;

public class JourneyDetailRef{

    @SerializedName("ref")
    private String ref;

    public String getRef(){
        return ref;
    }
}