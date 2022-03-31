package fortifiedid.bankidapi.cancel;

import fortifiedid.bankidapi.cancel.CancelRequest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CancelRequestTest
{
    @Test
    public void testEmptyJson() throws Exception
    {
        final String JSON = "{}";

        CancelRequest request = CancelRequest.parseJson(JSON.getBytes());
        assertEquals(null,request.orderRef);

        String json = request.toJson();
        request = CancelRequest.parseJson(json.getBytes());

        assertEquals(null,request.orderRef);
    }

    @Test
    public void testJson() throws Exception
    {
        final String JSON = "{\"orderRef\" : \"ref123\"}";

        CancelRequest request = CancelRequest.parseJson(JSON.getBytes());
        assertEquals("ref123",request.orderRef);

        String json = request.toJson();
        request = CancelRequest.parseJson(json.getBytes());

        assertEquals("ref123",request.orderRef);
    }
}
