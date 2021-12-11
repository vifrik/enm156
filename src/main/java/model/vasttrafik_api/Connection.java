package model.vasttrafik_api;

import okhttp3.*;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.Map;

public class Connection {
    private static final OkHttpClient CLIENT = new OkHttpClient().newBuilder().build();


    private static Response sendRequest(Request request) {
        try {
            return CLIENT.newCall(request).execute();
        } catch (SocketTimeoutException e) {
            System.err.println("Unable to reach API, timeout. Service may be down...");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static HttpUrl buildUrl(String scheme, String hostname, String pathSegments, Map<String, String> params) {
        HttpUrl.Builder builder = new HttpUrl.Builder()
                .scheme(scheme)
                .host(hostname)
                .addPathSegments(pathSegments)
                .addQueryParameter("format", "json");

        if (params != null) {
            for (Map.Entry<String, String> param : params.entrySet()) {
                builder.addQueryParameter(param.getKey(), param.getValue());
            }
        }

        return builder.build();
    }

    public static Response sendRequest(String scheme, String hostname, String pathSegments, String method, Map<String,
            String> params, Map<String, String> headers, RequestBody body, Auth auth) {
        HttpUrl httpUrl = buildUrl(scheme, hostname, pathSegments, params);
        Request request = buildRequest(httpUrl, method, headers, body, auth);

        return sendRequest(request);
    }

    private static Request buildRequest(HttpUrl url, String method, Map<String, String> headers,
                                        RequestBody body, Auth auth) {
        okhttp3.Request.Builder builder = new okhttp3.Request.Builder()
                .url(url)
                .method(method, body);

        if (auth != null) {
            builder.addHeader("Authorization", "Bearer " + auth.getToken().getAccessToken());
        }

        if (headers != null) {
            for (Map.Entry<String, String> header : headers.entrySet()) {
                builder.addHeader(header.getKey(), header.getValue());
            }
        }

        return builder.build();
    }
}
