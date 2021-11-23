package vasttrafikAPI.responseClasses.v3.token;

import com.google.gson.annotations.SerializedName;

public class TokenV3 {

    @SerializedName("expiresIn")
    private int expiresIn;

    @SerializedName("token")
    private String token;

    public int getExpiresIn() {
        return expiresIn;
    }

    public String getToken() {
        return token;
    }
}