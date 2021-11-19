package VasttrafikAPI.ResponseClasses.Trip;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TripItem{

    @SerializedName("Leg")
    private List<LegItem> leg;

    @SerializedName("alternative")
    private String alternative;

    public List<LegItem> getLeg(){
        return leg;
    }

    public String getAlternative(){
        return alternative;
    }
}