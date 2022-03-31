package fortifiedid.bankidapi.sign;

import fortifiedid.bankidapi.sign.SignRequest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SignRequestTest
{
    @Test
    public void testEmptyJson() throws Exception
    {
        final String JSON = "{}";

        SignRequest request = SignRequest.parseJson(JSON.getBytes());
        assertEquals(null,request.endUserIp);
        assertEquals(null,request.personalNumber);
        assertEquals(null,request.userVisibleData);
        assertEquals(null,request.userNonVisibleData);

        String json = request.toJson();
        request = SignRequest.parseJson(json.getBytes());

        assertEquals(null,request.endUserIp);
        assertEquals(null,request.personalNumber);
        assertEquals(null,request.userVisibleData);
        assertEquals(null,request.userNonVisibleData);
    }

    @Test
    public void testJson() throws Exception
    {
        final String JSON = "{\"endUserIp\" : \"1.2.3.4\" , \"personalNumber\" : \"197010100123\", \"userVisibleData\" : \"visibleData123\", \"userNonVisibleData\" : \"nonVisibleData123\"}";

        SignRequest request = SignRequest.parseJson(JSON.getBytes());
        assertEquals("1.2.3.4",request.endUserIp);
        assertEquals("197010100123",request.personalNumber);
        assertEquals("visibleData123",request.userVisibleData);
        assertEquals("nonVisibleData123",request.userNonVisibleData);

        String json = request.toJson();
        request = SignRequest.parseJson(json.getBytes());

        assertEquals("1.2.3.4",request.endUserIp);
        assertEquals("197010100123",request.personalNumber);
        assertEquals("visibleData123",request.userVisibleData);
        assertEquals("nonVisibleData123",request.userNonVisibleData);
    }
}
