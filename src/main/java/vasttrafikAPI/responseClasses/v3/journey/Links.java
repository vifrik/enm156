package vasttrafikAPI.responseClasses.v3.journey;

import com.google.gson.annotations.SerializedName;

public class Links {

    @SerializedName("current")
    private String current;

    public String getCurrent() {
        return current;
    }

    @Override
    public String toString() {
        return
                "Links{" +
                        "current = '" + current + '\'' +
                        "}";
    }
}