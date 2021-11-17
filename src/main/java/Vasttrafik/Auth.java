package Vasttrafik;

import Vasttrafik.ResponseClasses.Token;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.util.HashMap;
import java.util.Map;

public class Auth {
    public static Token getToken() {
        final String encodedString = "X0MxVXJ4YzhOWDJRTVlkc3FmS25lWkxkRVJJYTpSSUJucHZnOVFKNVNHQUtHZUR4VDdoOVpqSllh";

        Map<String, String> auth = new HashMap<>();
        auth.put("Authorization", "Bearer " + encodedString);

        RequestBody formBody = new FormBody.Builder()
                .add("grant_type", "client_credentials").build();

        Response response = Connection.sendRequest("token", "POST", null, auth, formBody);

        return JSON.objFromJson(response, Token.class);
    }
}
