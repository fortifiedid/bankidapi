package fortifiedid.bankidapi.environment;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EnvironmentTestTest
{
    @Test
    public void testGetWebServiceUrl() throws Exception
    {
        assertEquals("https://appapi2.test.bankid.com/rp/v5.1",new EnvironmentTest().getWebServiceUrl());
    }
}
