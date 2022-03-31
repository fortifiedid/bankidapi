package fortifiedid.bankidapi.auth;

import fortifiedid.bankidapi.entities.EndUserIp;
import fortifiedid.bankidapi.entities.PersonalNumber;
import fortifiedid.bankidapi.entities.Requirement;
import fortifiedid.bankidapi.util.JsonParser;
import fortifiedid.bankidapi.util.JsonParserException;
import java.nio.charset.Charset;

public class AuthRequest {

    public String endUserIp;
    public String personalNumber;
    public Requirement Requirement;
    
    public static final String URI="/auth";

    public AuthRequest(EndUserIp ip) {

        this.endUserIp = ip.toString();
    }

    private AuthRequest() {

    }

    public void personalNumer(PersonalNumber pnr) {
        this.personalNumber = pnr.toString();
    }

    public void requirement(Requirement Requirement) {
        this.Requirement = Requirement;
    }

    public static AuthRequest parseJson(byte[] jsonData) throws JsonParserException {
        return new JsonParser().parse(jsonData, AuthRequest.class);
    }

    public String toJson() throws JsonParserException {
        return new JsonParser().toJson(this);
    }

    public byte[] toByte() throws JsonParserException {
        return new JsonParser().toJson(this).getBytes(Charset.forName("UTF-8"));
    }
}
