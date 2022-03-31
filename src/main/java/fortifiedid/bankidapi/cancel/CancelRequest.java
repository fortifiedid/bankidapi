package fortifiedid.bankidapi.cancel;

import fortifiedid.bankidapi.util.JsonParser;
import fortifiedid.bankidapi.util.JsonParserException;

public class CancelRequest
{
    public String orderRef;

    public static CancelRequest parseJson(byte[]jsonData) throws JsonParserException
    {
        return new JsonParser().parse(jsonData,CancelRequest.class);
    }

    public String toJson() throws JsonParserException
    {
        return new JsonParser().toJson(this);
    }
}
