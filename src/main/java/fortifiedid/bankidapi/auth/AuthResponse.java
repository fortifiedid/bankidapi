package fortifiedid.bankidapi.auth;

import fortifiedid.bankidapi.util.JsonParser;
import fortifiedid.bankidapi.util.JsonParserException;

public class AuthResponse {

    private String orderRef;
    private String autoStartToken;
    private String qrStartToken;
    private String qrStartSecret;

    public static AuthResponse parseJson(byte[] jsonData) throws JsonParserException {
        return new JsonParser().parse(jsonData, AuthResponse.class);
    }

    public String toJson() throws JsonParserException {
        return new JsonParser().toJson(this);
    }

    /**
     * @return the orderRef
     */
    public String getOrderRef() {
        return orderRef;
    }

    /**
     * @return the autoStartToken
     */
    public String getAutoStartToken() {
        return autoStartToken;
    }

    /**
     * @return the qrStartToken
     */
    public String getQrStartToken() {
        return qrStartToken;
    }

    /**
     * @return the qrStartSecret
     */
    public String getQrStartSecret() {
        return qrStartSecret;
    }
}
