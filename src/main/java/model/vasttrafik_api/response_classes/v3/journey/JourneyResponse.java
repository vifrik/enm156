package model.vasttrafik_api.response_classes.v3.journey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JourneyResponse {

    @SerializedName("links")
    private Links links;

    @SerializedName("results")
    private List<ResultsItem> results;

    public Links getLinks() {
        return links;
    }

    public List<ResultsItem> getResults() {
        return results;
    }

    @Override
    public String toString() {
        return
                "JourneyResponse{" +
                        "links = '" + links + '\'' +
                        ",results = '" + results + '\'' +
                        "}";
    }
}