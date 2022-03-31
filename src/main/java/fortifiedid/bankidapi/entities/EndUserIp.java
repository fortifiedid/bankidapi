package fortifiedid.bankidapi.entities;

public class EndUserIp
{
    private final String endUserIp;

    public EndUserIp(String endUserIp)
    {
        this.endUserIp = endUserIp;
    }

    @Override
    public String toString()
    {
        return endUserIp;
    }
}
