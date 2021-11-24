package model.vasttrafik_api.response_classes;

import com.google.gson.annotations.SerializedName;

public class Token {
    @SerializedName("scope")
    private String scope;

    @SerializedName("token_type")
    private String tokenType;

    @SerializedName("expires_in")
    private int expiresIn;

    @SerializedName("access_token")
    private String accessToken;

    public String getScope() {
        return scope;
    }

    public String getTokenType() {
        return tokenType;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public String getAccessToken() {
        return this.accessToken;
    }
}
