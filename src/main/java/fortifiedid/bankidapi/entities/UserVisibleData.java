package fortifiedid.bankidapi.entities;

import fortifiedid.bankidapi.util.Base64;
import fortifiedid.bankidapi.util.ByteArray;

public class UserVisibleData
{
    private final String data;

    public UserVisibleData(String data)
    {
        this.data = data;
    }

    @Override
    public String toString()
    {
        return data;
    }

    public String toBase64()
    {
        return Base64.encode(ByteArray.fromUTF8String(data));
    }
}
