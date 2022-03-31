package fortifiedid.bankidapi.entities;

import fortifiedid.bankidapi.entities.UserVisibleData;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserVisibleDataTest
{
    @Test
    public void testConstructor() throws Exception
    {
        UserVisibleData data = new UserVisibleData("testdata123");
        assertEquals("testdata123",data.toString());
        assertEquals("dGVzdGRhdGExMjM=",data.toBase64());
    }
}
