package fortifiedid.bankidapi.cancel;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class CancelRequestTest {

    @Test
    public void testEmptyJson() throws Exception {
        CancelRequest request = new CancelRequest("123445");

        
        assertTrue(new String(request.toByte()).equalsIgnoreCase("{\"orderRef\":\"123445\"}"));
        
        

    }

}
