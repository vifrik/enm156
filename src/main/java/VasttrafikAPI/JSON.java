package VasttrafikAPI;

import com.google.gson.Gson;
import okhttp3.Response;

import java.io.IOException;

public class JSON {
    public static Gson gson = new Gson();

    public static <T> T objFromJson(Response response, Class<T> classOfT) {
        try {
            String body = response.body().string();
            return gson.fromJson(body, classOfT);
        } catch (IOException e) {
            System.err.println("Error converting to JSON object");
            e.printStackTrace();
        }

        return null;
    }

    public static <T> T objFromJson(String data, Class<T> classOfT) {
        return gson.fromJson(data, classOfT);
    }
}
