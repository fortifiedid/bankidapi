package fortifiedid.bankidapi.collect;

import fortifiedid.bankidapi.collect.CollectRequest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CollectRequestTest
{
    @Test
    public void testEmptyJson() throws Exception
    {
        final String JSON = "{}";

        CollectRequest request = CollectRequest.parseJson(JSON.getBytes());
        assertEquals(null,request.orderRef);

        String json = request.toJson();
        request = CollectRequest.parseJson(json.getBytes());

        assertEquals(null,request.orderRef);
    }

    @Test
    public void testJson() throws Exception
    {
        final String JSON = "{\"orderRef\" : \"ref123\"}";

        CollectRequest request = CollectRequest.parseJson(JSON.getBytes());
        assertEquals("ref123",request.orderRef);

        String json = request.toJson();
        request = CollectRequest.parseJson(json.getBytes());

        assertEquals("ref123",request.orderRef);
    }
}
