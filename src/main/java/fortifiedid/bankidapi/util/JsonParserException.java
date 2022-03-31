package fortifiedid.bankidapi.util;

public class JsonParserException extends RuntimeException
{
    public JsonParserException(String message, Exception e)
    {
        super(message,e);
    }
}
