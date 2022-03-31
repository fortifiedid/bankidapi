package fortifiedid.bankidapi.collect;

import fortifiedid.bankidapi.collect.CollectResponse;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CollectResponseTest
{
    @Test
    public void testEmptyJson() throws Exception
    {
        final String JSON = "{}";

        CollectResponse response = CollectResponse.parseJson(JSON.getBytes());
        assertEquals(null,response.orderRef);
        assertEquals(null,response.status);
        assertEquals(null,response.hintCode);

        String json = response.toJson();
        response = CollectResponse.parseJson(json.getBytes());

        assertEquals(null,response.orderRef);
        assertEquals(null,response.status);
        assertEquals(null,response.hintCode);
    }

    @Test
    public void testJson() throws Exception
    {
        final String JSON = "{\"orderRef\":\"ref123\", \"status\":\"pending\", \"hintCode\":\"outstandingTransaction\"}";

        CollectResponse response = CollectResponse.parseJson(JSON.getBytes());
        assertEquals("ref123",response.orderRef);
        assertEquals("pending",response.status);
        assertEquals("outstandingTransaction",response.hintCode);

        String json = response.toJson();
        response = CollectResponse.parseJson(json.getBytes());

        assertEquals("ref123",response.orderRef);
        assertEquals("pending",response.status);
        assertEquals("outstandingTransaction",response.hintCode);
    }

}
