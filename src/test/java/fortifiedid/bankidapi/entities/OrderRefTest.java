package fortifiedid.bankidapi.entities;

import fortifiedid.bankidapi.entities.OrderRef;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrderRefTest
{
    @Test
    public void testConstructor() throws Exception
    {
        OrderRef orderRef = new OrderRef("apa123");
        assertEquals("apa123",orderRef.toString());
    }
}
