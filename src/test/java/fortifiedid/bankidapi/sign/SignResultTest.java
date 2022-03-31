package fortifiedid.bankidapi.sign;

import fortifiedid.bankidapi.sign.SignResult;
import fortifiedid.bankidapi.entities.AutoStartToken;
import fortifiedid.bankidapi.entities.OrderRef;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SignResultTest
{
    @Test
    public void testConstructor() throws Exception
    {
        SignResult result = new SignResult(
                new OrderRef("bc8b0a7b-64de-4256-8662-0ca2dd71f1eb"),
                new AutoStartToken("c9bc8c00-4de5-4012-86f0-63c16dc83798"));

        assertEquals("bc8b0a7b-64de-4256-8662-0ca2dd71f1eb",result.orderRef.toString());
        assertEquals("c9bc8c00-4de5-4012-86f0-63c16dc83798",result.autoStartToken.toString());
    }
}
