package fortifiedid.bankidapi.sign;

import fortifiedid.bankidapi.util.JsonParser;
import fortifiedid.bankidapi.util.JsonParserException;

public class SignResponse
{
    public String orderRef;
    public String autoStartToken;

    public static SignResponse parseJson(byte[]jsonData) throws JsonParserException
    {
        return new JsonParser().parse(jsonData,SignResponse.class);
    }

    public String toJson() throws JsonParserException
    {
        return new JsonParser().toJson(this);
    }
}
