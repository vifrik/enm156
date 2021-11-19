package VasttrafikAPI.ResponseClasses.Trip;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Notes{

    @SerializedName("Note")
    private List<NoteItem> note;

    public List<NoteItem> getNote(){
        return note;
    }
}