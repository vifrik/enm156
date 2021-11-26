package model.vasttrafik_api;

import model.vasttrafik_api.response_classes.Token;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.util.HashMap;
import java.util.Map;

public class Auth {
    private Token token;
    private long sysTimeSeconds;

    public Auth() {
        token = requestToken();
        sysTimeSeconds = getSysTimeSeconds();
    }

    public Token getToken() {
        validate();
        return token;
    }

    private void validate() {
        if (getSysTimeSeconds() > sysTimeSeconds + token.getExpiresIn()) {
            token = getToken();
        }
    }

    private long getSysTimeSeconds() {
        return System.currentTimeMillis() / 1000;
    }

    public Token requestToken() {
        final String encodedString = "cTBVSzlpVk82Zm9LSW00alI2SGNvcmc5RkZFYTpyWnZEMVhkWW9ObExuS2RWU3FRWFZxelZScDRh";

        Map<String, String> auth = new HashMap<>();
        auth.put("Authorization", "Bearer " + encodedString);

        RequestBody formBody = new FormBody.Builder()
                .add("grant_type", "client_credentials").build();

        Response response = Connection.sendRequest("https", "api.vasttrafik.se", "token",
                "POST", null, auth, formBody, null);

        return JSON.objFromJson(response, Token.class);
    }
}
