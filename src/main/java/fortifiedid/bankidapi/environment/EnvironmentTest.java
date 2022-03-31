package fortifiedid.bankidapi.environment;

public class EnvironmentTest implements Environment
{
    @Override
    public String getWebServiceUrl()
    {
        return "https://appapi2.test.bankid.com/rp/v5.1";
    }
}
