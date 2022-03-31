package fortifiedid.bankidapi.auth;

import fortifiedid.bankidapi.entities.EndUserIp;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AuthRequestTest
{
    @Test
    public void testEmptyJson() throws Exception
    {
        final String JSON = "{}";

        AuthRequest request = AuthRequest.parseJson(JSON.getBytes());
        assertEquals(null,request.endUserIp);
        assertEquals(null,request.personalNumber);

        String json = request.toJson();
        request = AuthRequest.parseJson(json.getBytes());

        assertEquals(null,request.endUserIp);
        assertEquals(null,request.personalNumber);
    }
    
    @Test
    public void test() throws Exception
    {
        final String JSON = "{}";

        AuthRequest request = new AuthRequest(new EndUserIp("192.168.0.13"));
        
        
        
    }

    @Test
    public void testJson() throws Exception
    {
        final String JSON = "{\"endUserIp\" : \"1.2.3.4\" , \"personalNumber\" : \"197010100123\"}";

        AuthRequest request = AuthRequest.parseJson(JSON.getBytes());
        assertEquals("1.2.3.4",request.endUserIp);
        assertEquals("197010100123",request.personalNumber);

        String json = request.toJson();
        request = AuthRequest.parseJson(json.getBytes());

        assertEquals("1.2.3.4",request.endUserIp);
        assertEquals("197010100123",request.personalNumber);
    }
}
