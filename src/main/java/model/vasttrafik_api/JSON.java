package model.vasttrafik_api;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
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
        } catch (JsonSyntaxException e) {
            System.err.println("Error converting to JSON object");
        }

        return null;
    }

    public static <T> T objFromJson(String data, Class<T> classOfT) {
        return gson.fromJson(data, classOfT);
    }
}
