package VasttrafikAPI.ResponseClasses.Trip;

import com.google.gson.annotations.SerializedName;

public class JourneyDetailRef{

    @SerializedName("ref")
    private String ref;

    public String getRef(){
        return ref;
    }
}