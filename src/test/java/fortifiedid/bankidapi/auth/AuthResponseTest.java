package fortifiedid.bankidapi.auth;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import org.junit.Ignore;

public class AuthResponseTest {

    @Test
    public void testEmptyJson() throws Exception {
        final String JSON = "{}";

        AuthResponse response = AuthResponse.parseJson(JSON.getBytes());
        assertEquals(null, response.getOrderRef());
        assertEquals(null, response.getAutoStartToken());

        String json = response.toJson();
        response = AuthResponse.parseJson(json.getBytes());

        assertEquals(null, response.getOrderRef());
        assertEquals(null, response.getAutoStartToken());
        assertEquals(null, response.getQrStartSecret());
        assertEquals(null, response.getQrStartToken());
    }

    @Test

    public void testJson() throws Exception {
        final String JSON = "{\"orderRef\" : \"orderref123\" , \"autoStartToken\" : \"autostart123\"}";

        AuthResponse response = AuthResponse.parseJson(JSON.getBytes());
        assertEquals("orderref123", response.getOrderRef());
        assertEquals("autostart123", response.getAutoStartToken());

        String json = response.toJson();
        response = AuthResponse.parseJson(json.getBytes());

        assertEquals("orderref123", response.getOrderRef());
        assertEquals("autostart123", response.getAutoStartToken());
    }
}
