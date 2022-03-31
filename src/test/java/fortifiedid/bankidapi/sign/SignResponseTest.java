package fortifiedid.bankidapi.sign;

import fortifiedid.bankidapi.sign.SignResponse;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SignResponseTest
{
    @Test
    public void testEmptyJson() throws Exception
    {
        final String JSON = "{}";

        SignResponse response = SignResponse.parseJson(JSON.getBytes());
        assertEquals(null,response.orderRef);
        assertEquals(null,response.autoStartToken);

        String json = response.toJson();
        response = SignResponse.parseJson(json.getBytes());

        assertEquals(null,response.orderRef);
        assertEquals(null,response.autoStartToken);
    }

    @Test
    public void testJson() throws Exception
    {
        final String JSON = "{\"orderRef\" : \"orderref123\" , \"autoStartToken\" : \"autostart123\"}";

        SignResponse response = SignResponse.parseJson(JSON.getBytes());
        assertEquals("orderref123",response.orderRef);
        assertEquals("autostart123",response.autoStartToken);

        String json = response.toJson();
        response = SignResponse.parseJson(json.getBytes());

        assertEquals("orderref123",response.orderRef);
        assertEquals("autostart123",response.autoStartToken);
    }
}
