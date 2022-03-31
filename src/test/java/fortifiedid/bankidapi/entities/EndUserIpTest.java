package fortifiedid.bankidapi.entities;

import fortifiedid.bankidapi.entities.EndUserIp;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EndUserIpTest
{
    @Test
    public void testConstructor() throws Exception
    {
        EndUserIp endUserIp = new EndUserIp("1.2.3.4");
        assertEquals("1.2.3.4",endUserIp.toString());
    }
}
