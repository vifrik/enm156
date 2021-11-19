package VasttrafikAPI.ResponseClasses.Trip;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TripItem{

    @SerializedName("valid")
    private boolean valid;

    @SerializedName("alternative")
    private boolean alternative;

    @SerializedName("travelWarranty")
    private boolean travelWarranty;

    @SerializedName("type")
    private String type;

    @SerializedName("Leg")
    private List<LegItem> leg;

    public boolean isValid(){
        return valid;
    }

    public boolean isAlternative(){
        return alternative;
    }

    public boolean isTravelWarranty(){
        return travelWarranty;
    }

    public String getType(){
        return type;
    }

    public List<LegItem> getLeg(){
        return leg;
    }
}