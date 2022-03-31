package fortifiedid.bankidapi.entities;

public class AutoStartToken
{
    private final String autoStartToken;

    public AutoStartToken(String autoStartToken)
    {
        this.autoStartToken = autoStartToken;
    }

    @Override
    public String toString()
    {
        return autoStartToken;
    }
}


