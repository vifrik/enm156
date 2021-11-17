package Vasttrafik.ResponseClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Token {
    @SerializedName("scope")
    @Expose
    private final String scope;

    @SerializedName("token_type")
    @Expose
    private final String tokenType;

    @SerializedName("expires_in")
    @Expose
    private final int expiresIn;

    @SerializedName("access_token")
    @Expose
    private final String accessToken;

    public Token(String scope, String token_type, int expires_in, String access_token) {
        this.scope = scope;
        this.tokenType = token_type;
        this.expiresIn = expires_in;
        this.accessToken = access_token;
    }

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
