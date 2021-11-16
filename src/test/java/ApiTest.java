import okhttp3.Response;

public class ApiTest {
    public static void main(String[] args) {
        Vasttrafik vasttrafik = new Vasttrafik();
        Response response = vasttrafik.getStationsFromCoordinates(11.973372, 57.689953);
    }
}
