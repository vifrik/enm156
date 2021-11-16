import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Vasttrafik {
    public static final String SCHEME = "https";
    public static final String HOSTNAME = "api.vasttrafik.se";
    public static final String SUB_PATH = "bin/rest.exe/v2";

    OkHttpClient client;

    public Vasttrafik () {
        client = new OkHttpClient().newBuilder().build();
    }

    private Map<String,String> getNearbyStopsAuth() {
        Map<String, String> auth = new HashMap<>();
        auth.put("Authorization", "Bearer f2385823-722b-3ce2-aed5-5de7e3642f4f");
        return auth;
    }

    private HttpUrl getUrl(String api, Map<String,String> params) {
        HttpUrl.Builder builder = new HttpUrl.Builder()
                .scheme(SCHEME)
                .host(HOSTNAME)
                .addPathSegment(SUB_PATH)
                .addPathSegment(api)
                .addQueryParameter("format", "json");

        for(Map.Entry<String, String> param : params.entrySet()) {
            builder.addQueryParameter(param.getKey(),param.getValue());
        }

        return builder.build();
    }

    private Response sendRequest(String api, String method, Map<String,String> params, Map<String,String> headers) {
        HttpUrl httpUrl = getUrl(api, params);

        Request.Builder builder = new Request.Builder()
                .url(httpUrl)
                .method(method, null);

        for(Map.Entry<String, String> header : headers.entrySet()) {
            builder.addHeader(header.getKey(),header.getValue());
        }

        Request request = builder.build();

        try {
            return client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Response getStationsFromCoordinates(double lon, double lat) {
        Map<String, String> params = new HashMap<>();
        params.put("originCoordLat", String.valueOf(lat));
        params.put("originCoordLong", String.valueOf(lon));

        return sendRequest("location.nearbystops", "GET", params, getNearbyStopsAuth());
    }
}
