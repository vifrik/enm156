package vasttrafikAPI.responseClasses.departureBoard;

import com.google.gson.annotations.SerializedName;

public class JourneyDetailRef {

    @SerializedName("ref")
    private String ref;

    public String getRef() {
        return ref;
    }
}