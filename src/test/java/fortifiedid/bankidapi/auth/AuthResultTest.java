package fortifiedid.bankidapi.auth;

import fortifiedid.bankidapi.auth.AuthResult;
import fortifiedid.bankidapi.entities.AutoStartToken;
import fortifiedid.bankidapi.entities.OrderRef;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AuthResultTest
{
    @Test
    public void testConstructor() throws Exception
    {
        AuthResult authResult = new AuthResult(
                new OrderRef("bc8b0a7b-64de-4256-8662-0ca2dd71f1eb"),
                new AutoStartToken("c9bc8c00-4de5-4012-86f0-63c16dc83798"));

        assertEquals("bc8b0a7b-64de-4256-8662-0ca2dd71f1eb",authResult.orderRef.toString());
        assertEquals("c9bc8c00-4de5-4012-86f0-63c16dc83798",authResult.autoStartToken.toString());
    }
}
