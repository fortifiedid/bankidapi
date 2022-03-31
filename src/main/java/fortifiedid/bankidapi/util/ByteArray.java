package fortifiedid.bankidapi.util;

public class ByteArray
{
    public static byte[] fromUTF8String(String string)
    {
        try
        {
            return string.getBytes("UTF8");
        }
        catch(Exception e)
        {
            throw new RuntimeException("Unable to encode string UTF8",e);
        }
    }
}
