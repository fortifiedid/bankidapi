package fortifiedid.bankidapi.environment;

public class EnvironmentProduction implements Environment
{
    @Override
    public String getWebServiceUrl()
    {
        return "https://appapi2.bankid.com/rp/v5.1";
    }
}
