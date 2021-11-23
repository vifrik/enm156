package vasttrafikAPI.responseClasses.v3.journey;

import com.google.gson.annotations.SerializedName;

public class ResultsItem {

    @SerializedName("reconstructionReference")
    private String reconstructionReference;

    @SerializedName("destinationLink")
    private DestinationLink destinationLink;

    @SerializedName("detailsReference")
    private String detailsReference;

    public String getReconstructionReference() {
        return reconstructionReference;
    }

    public DestinationLink getDestinationLink() {
        return destinationLink;
    }

    public String getDetailsReference() {
        return detailsReference;
    }

    @Override
    public String toString() {
        return
                "ResultsItem{" +
                        "reconstructionReference = '" + reconstructionReference + '\'' +
                        ",destinationLink = '" + destinationLink + '\'' +
                        ",detailsReference = '" + detailsReference + '\'' +
                        "}";
    }
}