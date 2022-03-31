package fortifiedid.bankidapi.collect;

import fortifiedid.bankidapi.util.JsonParser;
import fortifiedid.bankidapi.util.JsonParserException;

public class CollectRequest
{
    public String orderRef;

    public static CollectRequest parseJson(byte[]jsonData) throws JsonParserException
    {
        return new JsonParser().parse(jsonData,CollectRequest.class);
    }

    public String toJson() throws JsonParserException
    {
        return new JsonParser().toJson(this);
    }
}
