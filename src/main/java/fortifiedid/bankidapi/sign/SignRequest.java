package fortifiedid.bankidapi.sign;

import fortifiedid.bankidapi.entities.Requirement;
import fortifiedid.bankidapi.util.JsonParser;
import fortifiedid.bankidapi.util.JsonParserException;

public class SignRequest
{
    public String endUserIp;
    public String personalNumber;
    public String userVisibleData;
    public String userNonVisibleData;
    public Requirement requirement;

    public static SignRequest parseJson(byte[]jsonData) throws JsonParserException
    {
        return new JsonParser().parse(jsonData, SignRequest.class);
    }

    public String toJson() throws JsonParserException
    {
        return new JsonParser().toJson(this);
    }
}

