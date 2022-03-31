package fortifiedid.bankidapi.environment;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EnvironmentCustomTest {

    @Test
    public void testGetWebServiceUrl() throws Exception {
	assertEquals("http://localhost:8080/rp/v5", new EnvironmentCustom("http://localhost:8080/rp/v5").getWebServiceUrl());
    }
}
