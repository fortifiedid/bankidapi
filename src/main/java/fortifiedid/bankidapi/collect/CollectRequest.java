package fortifiedid.bankidapi.collect;

import fortifiedid.bankidapi.util.JsonParser;
import fortifiedid.bankidapi.util.JsonParserException;
import java.nio.charset.Charset;

public class CollectRequest {

    public static final String URI = "/collect";
    private String orderRef;

    public CollectRequest(String orderRef) {
        this.orderRef = orderRef;
    }

    public String orderRef() {

        return orderRef;
    }

    private CollectRequest() {
    }

    public static CollectRequest parseJson(byte[] jsonData) throws JsonParserException {
        return new JsonParser().parse(jsonData, CollectRequest.class);
    }

    public String toJson() throws JsonParserException {
        return new JsonParser().toJson(this);
    }

    public byte[] toByte() throws JsonParserException {
        return new JsonParser().toJson(this).getBytes(Charset.forName("UTF-8"));
    }
}
