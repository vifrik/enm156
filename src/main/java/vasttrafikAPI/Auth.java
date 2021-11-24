package vasttrafikAPI;

import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;
import vasttrafikAPI.responseClasses.Token;
import vasttrafikAPI.responseClasses.v3.token.TokenV3;

import java.util.HashMap;
import java.util.Map;

public class Auth {
    public static Token getToken() {
        final String encodedString = "cTBVSzlpVk82Zm9LSW00alI2SGNvcmc5RkZFYTpyWnZEMVhkWW9ObExuS2RWU3FRWFZxelZScDRh";

        Map<String, String> auth = new HashMap<>();
        auth.put("Authorization", "Bearer " + encodedString);

        RequestBody formBody = new FormBody.Builder()
                .add("grant_type", "client_credentials").build();

        Response response = Connection.sendRequest("token", "POST", null, auth, formBody);

        return JSON.objFromJson(response, Token.class);
    }

    public static TokenV3 getTokenV3() {
        Map<String, String> auth = new HashMap<>();
        auth.put("Host", "www.vasttrafik.se");

        Response response = Connection.sendRequestV3("api/token/public/new", "GET", null, auth, null);

        return JSON.objFromJson(response, TokenV3.class);
    }
}
