package VasttrafikAPI.ResponseClasses.Trip;

import com.google.gson.annotations.SerializedName;

public class NoteItem{

    @SerializedName("severity")
    private String severity;

    @SerializedName("priority")
    private String priority;

    @SerializedName("key")
    private String key;

    public String getSeverity(){
        return severity;
    }

    public String getPriority(){
        return priority;
    }

    public String getKey(){
        return key;
    }
}