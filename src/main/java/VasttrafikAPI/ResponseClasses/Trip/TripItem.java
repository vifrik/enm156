package VasttrafikAPI.ResponseClasses.Trip;

import java.util.Comparator;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TripItem{
    public static class TripComparator implements Comparator<TripItem>{
        @Override
        public int compare(TripItem o1, TripItem o2) {
            return Double.compare(o1.score, o2.score);
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(score);
        sb.append("\n");
        for(LegItem l : leg){
            sb.append(l);
            sb.append("\n");
        }
        return sb.toString();
    }

    @SerializedName("Leg")
    private List<LegItem> leg;

    private double score;

    @SerializedName("alternative")
    private String alternative;

    public List<LegItem> getLeg(){
        return leg;
    }

    public String getAlternative(){
        return alternative;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}