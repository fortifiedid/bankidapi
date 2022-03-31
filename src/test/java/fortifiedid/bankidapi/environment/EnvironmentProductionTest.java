package fortifiedid.bankidapi.environment;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EnvironmentProductionTest
{
    @Test
    public void testGetWebServiceUrl() throws Exception
    {
        assertEquals("https://appapi2.bankid.com/rp/v5.1",new EnvironmentProduction().getWebServiceUrl());
    }
}
