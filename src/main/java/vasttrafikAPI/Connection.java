package vasttrafikAPI;

import okhttp3.*;

import java.io.IOException;
import java.util.Map;

public class Connection {
    public static final String SCHEME = "https";
    public static final String HOSTNAME = "api.vasttrafik.se";
    static OkHttpClient client = new OkHttpClient().newBuilder().build();

    public static HttpUrl getUrl(String api, Map<String, String> params) {
        HttpUrl.Builder builder = new HttpUrl.Builder()
                .scheme(SCHEME)
                .host(HOSTNAME)
                .addPathSegments(api)
                .addQueryParameter("format", "json");

        if (params != null) {
            for (Map.Entry<String, String> param : params.entrySet()) {
                builder.addQueryParameter(param.getKey(), param.getValue());
            }
        }

        return builder.build();
    }

    public static Request getRequest(HttpUrl url, String method, Map<String, String> headers, RequestBody body) {
        okhttp3.Request.Builder builder = new okhttp3.Request.Builder()
                .url(url)
                .method(method, body);

        if (headers != null) {
            for (Map.Entry<String, String> header : headers.entrySet()) {
                builder.addHeader(header.getKey(), header.getValue());
            }
        }

        return builder.build();
    }

    public static Request getRequest(String url, String method, Map<String, String> headers, RequestBody body) {
        okhttp3.Request.Builder builder = new okhttp3.Request.Builder()
                .url(url)
                .method(method, body);

        if (headers != null) {
            for (Map.Entry<String, String> header : headers.entrySet()) {
                builder.addHeader(header.getKey(), header.getValue());
            }
        }

        return builder.build();
    }

    public static Response sendRequest(Request request) {
        try {
            return client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Response sendRequest(String api, String method, Map<String, String> params, Map<String, String> headers, RequestBody body) {
        HttpUrl httpUrl = getUrl(api, params);
        Request request = getRequest(httpUrl, method, headers, body);

        return sendRequest(request);
    }
}
