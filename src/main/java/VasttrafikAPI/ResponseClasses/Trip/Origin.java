package VasttrafikAPI.ResponseClasses.Trip;

import com.google.gson.annotations.SerializedName;

public class Origin{

    @SerializedName("date")
    private String date;

    @SerializedName("$")
    private String ;

    @SerializedName("rtTrack")
    private String rtTrack;

    @SerializedName("routeIdx")
    private String routeIdx;

    @SerializedName("directdate")
    private String directdate;

    @SerializedName("type")
    private String type;

    @SerializedName("directtime")
    private String directtime;

    @SerializedName("name")
    private String name;

    @SerializedName("cancelled")
    private boolean cancelled;

    @SerializedName("id")
    private String id;

    @SerializedName("rtDate")
    private String rtDate;

    @SerializedName("time")
    private String time;

    @SerializedName("track")
    private String track;

    @SerializedName("rtTime")
    private String rtTime;

    @SerializedName("Notes")
    private Notes notes;

    public String getDate(){
        return date;
    }

    public String get(){
        return ;
    }

    public String getRtTrack(){
        return rtTrack;
    }

    public String getRouteIdx(){
        return routeIdx;
    }

    public String getDirectdate(){
        return directdate;
    }

    public String getType(){
        return type;
    }

    public String getDirecttime(){
        return directtime;
    }

    public String getName(){
        return name;
    }

    public boolean isCancelled(){
        return cancelled;
    }

    public String getId(){
        return id;
    }

    public String getRtDate(){
        return rtDate;
    }

    public String getTime(){
        return time;
    }

    public String getTrack(){
        return track;
    }

    public String getRtTime(){
        return rtTime;
    }

    public Notes getNotes(){
        return notes;
    }
}