package fortifiedid.bankidapi.cancel;

import fortifiedid.bankidapi.util.JsonParser;
import fortifiedid.bankidapi.util.JsonParserException;
import java.nio.charset.Charset;

public class CancelRequest {

    public static final String URI = "/cancel";
    public String orderRef;

    public CancelRequest(String orderRef) {

        this.orderRef = orderRef;
    }

    private CancelRequest() {

    }

    public static CancelRequest parseJson(byte[] jsonData) throws JsonParserException {
        return new JsonParser().parse(jsonData, CancelRequest.class);
    }

    public String toJson() throws JsonParserException {
        return new JsonParser().toJson(this);
    }

    public byte[] toByte() throws JsonParserException {
        return new JsonParser().toJson(this).getBytes(Charset.forName("UTF-8"));
    }
}
