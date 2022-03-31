package fortifiedid.bankidapi.entities;

import fortifiedid.bankidapi.util.Base64;

public class UserNonVisibleData
{
    private final byte[]data;

    public UserNonVisibleData(byte[]data)
    {
        if(data == null)
            throw new NullPointerException("Non visible data was null");

        this.data = data;
    }

    public String toBase64()
    {
        return Base64.encode(data);
    }
}
